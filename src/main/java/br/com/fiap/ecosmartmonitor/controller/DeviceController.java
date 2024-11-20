package br.com.fiap.ecosmartmonitor.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.ecosmartmonitor.dao.DeviceDAO;
import br.com.fiap.ecosmartmonitor.factory.DAOFactory;
import br.com.fiap.ecosmartmonitor.model.Device;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Controlador responsável por gerenciar as operações relacionadas aos dispositivos.
 * Proporciona endpoints RESTful para CRUD de dispositivos.
 *
 * Base URL: /devices
 *
 * @produces MediaType.APPLICATION_JSON - Respostas no formato JSON.
 * @consumes MediaType.APPLICATION_JSON - Requisições com corpo em formato JSON.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
@Path("/devices")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeviceController {

    private final DeviceDAO deviceDAO;

    /**
     * Construtor da classe DeviceController.
     * Inicializa o DAO de dispositivo utilizando a fábrica DAO.
     *
     * @throws SQLException caso ocorra erro na conexão com o banco de dados.
     */
    public DeviceController() throws SQLException {
        this.deviceDAO = DAOFactory.getDeviceDAO();
    }

    /**
     * Recupera um dispositivo específico pelo ID.
     *
     * @param id ID do dispositivo a ser buscado.
     * @return Response com o dispositivo encontrado ou erro caso não exista.
     */
    @GET
    @Path("/{id}")
    public Response getDeviceById(@PathParam("id") Long id) {
        Device device = deviceDAO.getDeviceById(id);
        if (device != null) {
            return Response.ok(device).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Device not found for ID: " + id)
                    .build();
        }
    }

    /**
     * Recupera os dispositivos associados a uma residência específica.
     *
     * @param residenceId ID da residência para a qual os dispositivos serão buscados.
     * @return Response com a lista de dispositivos encontrados ou erro caso não existam dispositivos.
     */
    @GET
    @Path("/residence/{residenceId}")
    public Response getDevicesByResidenceId(@PathParam("residenceId") Long residenceId) {
        List<Device> devices = deviceDAO.getDevicesByResidenceId(residenceId);
        if (devices != null && !devices.isEmpty()) {
            return Response.ok(devices).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No devices found for residence ID: " + residenceId)
                    .build();
        }
    }

    /**
     * Cria um novo dispositivo.
     *
     * @param device Objeto Device com os dados do dispositivo a ser criado.
     * @return Response indicando o sucesso ou erro na criação.
     */
    @POST
    public Response createDevice(Device device) {
        try {
            deviceDAO.createDevice(device);
            return Response.status(Response.Status.CREATED)
                    .entity("Device created successfully!")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error creating device: " + e.getMessage())
                    .build();
        }
    }

    /**
     * Atualiza um dispositivo existente pelo ID.
     *
     * @param id           ID do dispositivo a ser atualizado.
     * @param updatedDevice Objeto Device com os novos dados do dispositivo.
     * @return Response indicando o sucesso ou erro na atualização.
     */
    @PUT
    @Path("/{id}")
    public Response updateDevice(@PathParam("id") Long id, Device updatedDevice) {
        Device existingDevice = deviceDAO.getDeviceById(id);
        if (existingDevice == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Device not found for ID: " + id)
                    .build();
        }
        try {
            updatedDevice.setId(id);
            deviceDAO.updateDevice(updatedDevice);
            return Response.ok("Device updated successfully!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error updating device: " + e.getMessage())
                    .build();
        }
    }

    /**
     * Exclui um dispositivo existente pelo ID.
     *
     * @param id ID do dispositivo a ser excluído.
     * @return Response indicando o sucesso ou erro na exclusão.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteDevice(@PathParam("id") Long id) {
        Device existingDevice = deviceDAO.getDeviceById(id);
        if (existingDevice == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Device not found for ID: " + id)
                    .build();
        }
        try {
            deviceDAO.deleteDevice(id);
            return Response.ok("Device deleted successfully!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error deleting device: " + e.getMessage())
                    .build();
        }
    }
}
