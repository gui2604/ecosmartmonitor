package br.com.fiap.ecosmartmonitor.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.ecosmartmonitor.dao.ConsumptionDAO;
import br.com.fiap.ecosmartmonitor.factory.DAOFactory;
import br.com.fiap.ecosmartmonitor.model.Consumption;
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
 * Controlador responsável por gerenciar as operações relacionadas ao consumo de energia.
 * Proporciona endpoints RESTful para CRUD dos registros de consumo.
 *
 * Base URL: /consumption
 *
 * @produces MediaType.APPLICATION_JSON - Respostas no formato JSON.
 * @consumes MediaType.APPLICATION_JSON - Requisições com corpo em formato JSON.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
@Path("/consumption")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConsumptionController {

    private final ConsumptionDAO consumptionDAO;

    /**
     * Construtor da classe ConsumptionController.
     * Inicializa o DAO de consumo utilizando a fábrica DAO.
     *
     * @throws SQLException caso ocorra erro na conexão com o banco de dados.
     */
    public ConsumptionController() throws SQLException {
        this.consumptionDAO = DAOFactory.getConsumptionDAO();
    }

    /**
     * Recupera um registro de consumo específico pelo ID.
     *
     * @param id ID do registro de consumo a ser buscado.
     * @return Response com o registro de consumo encontrado ou erro caso não exista.
     */
    @GET
    @Path("/{id}")
    public Response getConsumptionById(@PathParam("id") Long id) {
        Consumption consumption = consumptionDAO.getConsumptionById(id);
        if (consumption != null) {
            return Response.ok(consumption).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Consumption record not found for ID: " + id)
                    .build();
        }
    }

    /**
     * Recupera os registros de consumo associados a uma residência específica.
     *
     * @param residenceId ID da residência para a qual os registros de consumo serão buscados.
     * @return Response com a lista de registros encontrados ou erro caso não existam registros.
     */
    @GET
    @Path("/residence/{residenceId}")
    public Response getConsumptionByResidence(@PathParam("residenceId") Long residenceId) {
        List<Consumption> consumptions = consumptionDAO.getConsumptionsByResidenceId(residenceId);
        if (consumptions != null && !consumptions.isEmpty()) {
            return Response.ok(consumptions).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No consumption records found for residence ID: " + residenceId)
                    .build();
        }
    }

    /**
     * Cria um novo registro de consumo.
     *
     * @param consumption Objeto Consumption com os dados do registro a ser criado.
     * @return Response indicando o sucesso ou erro na criação.
     */
    @POST
    public Response createConsumption(Consumption consumption) {
        try {
            consumptionDAO.createConsumption(consumption);
            return Response.status(Response.Status.CREATED)
                    .entity("Consumption record created successfully!")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error creating consumption record: " + e.getMessage())
                    .build();
        }
    }

    /**
     * Atualiza um registro de consumo existente pelo ID.
     *
     * @param id                ID do registro de consumo a ser atualizado.
     * @param updatedConsumption Objeto Consumption com os novos dados do registro.
     * @return Response indicando o sucesso ou erro na atualização.
     */
    @PUT
    @Path("/{id}")
    public Response updateConsumption(@PathParam("id") Long id, Consumption updatedConsumption) {
        Consumption existingConsumption = consumptionDAO.getConsumptionById(id);
        if (existingConsumption == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Consumption record not found for ID: " + id)
                    .build();
        }
        try {
            updatedConsumption.setId(id);
            consumptionDAO.updateConsumption(updatedConsumption);
            return Response.ok("Consumption record updated successfully!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error updating consumption record: " + e.getMessage())
                    .build();
        }
    }

    /**
     * Exclui um registro de consumo existente pelo ID.
     *
     * @param id ID do registro de consumo a ser excluído.
     * @return Response indicando o sucesso ou erro na exclusão.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteConsumption(@PathParam("id") Long id) {
        Consumption existingConsumption = consumptionDAO.getConsumptionById(id);
        if (existingConsumption == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Consumption record not found for ID: " + id)
                    .build();
        }
        try {
            consumptionDAO.deleteConsumption(id);
            return Response.ok("Consumption record deleted successfully!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error deleting consumption record: " + e.getMessage())
                    .build();
        }
    }
}
