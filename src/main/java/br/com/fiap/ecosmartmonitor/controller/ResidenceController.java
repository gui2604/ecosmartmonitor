package br.com.fiap.ecosmartmonitor.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.ecosmartmonitor.dao.ResidenceDAO;
import br.com.fiap.ecosmartmonitor.factory.DAOFactory;
import br.com.fiap.ecosmartmonitor.model.Residence;
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
 * Controlador responsável por gerenciar as operações relacionadas às residências.
 * Proporciona endpoints RESTful para CRUD das residências.
 *
 * Base URL: /residences
 *
 * @produces MediaType.APPLICATION_JSON - Respostas no formato JSON.
 * @consumes MediaType.APPLICATION_JSON - Requisições com corpo em formato JSON.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
@Path("/residences")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResidenceController {

    private final ResidenceDAO residenceDAO;

    /**
     * Construtor da classe ResidenceController.
     * Inicializa o DAO de residências utilizando a fábrica DAO.
     *
     * @throws SQLException caso ocorra erro na conexão com o banco de dados.
     */
    public ResidenceController() throws SQLException {
        this.residenceDAO = DAOFactory.getResidenceDAO();
    }

    /**
     * Recupera uma residência específica pelo ID.
     *
     * @param id ID da residência a ser buscada.
     * @return Response com a residência encontrada ou erro caso não exista.
     */
    @GET
    @Path("/{id}")
    public Response getResidenceById(@PathParam("id") Long id) {
        Residence residence = residenceDAO.getResidenceById(id);
        if (residence != null) {
            return Response.ok(residence).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Residence not found for ID: " + id)
                    .build();
        }
    }

    /**
     * Recupera todas as residências associadas a um cliente específico.
     *
     * @param clientId ID do cliente para o qual as residências serão buscadas.
     * @return Response com a lista de residências encontradas ou erro caso não existam residências.
     */
    @GET
    @Path("/client/{clientId}")
    public Response getResidencesByClientId(@PathParam("clientId") Long clientId) {
        List<Residence> residences = residenceDAO.getResidencesByClientId(clientId);
        if (residences != null && !residences.isEmpty()) {
            return Response.ok(residences).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No residences found for client ID: " + clientId)
                    .build();
        }
    }

    /**
     * Cria uma nova residência.
     *
     * @param residence Objeto Residence com os dados da residência a ser criada.
     * @return Response indicando o sucesso ou erro na criação.
     */
    @POST
    public Response createResidence(Residence residence) {
        try {
            residenceDAO.createResidence(residence);
            return Response.status(Response.Status.CREATED)
                    .entity("Residence created successfully!")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error creating residence: " + e.getMessage())
                    .build();
        }
    }

    /**
     * Atualiza uma residência existente pelo ID.
     *
     * @param id               ID da residência a ser atualizada.
     * @param updatedResidence Objeto Residence com os novos dados da residência.
     * @return Response indicando o sucesso ou erro na atualização.
     */
    @PUT
    @Path("/{id}")
    public Response updateResidence(@PathParam("id") Long id, Residence updatedResidence) {
        Residence existingResidence = residenceDAO.getResidenceById(id);
        if (existingResidence == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Residence not found for ID: " + id)
                    .build();
        }
        try {
            updatedResidence.setId(id);
            residenceDAO.updateResidence(updatedResidence);
            return Response.ok("Residence updated successfully!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error updating residence: " + e.getMessage())
                    .build();
        }
    }

    /**
     * Exclui uma residência existente pelo ID.
     *
     * @param id ID da residência a ser excluída.
     * @return Response indicando o sucesso ou erro na exclusão.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteResidence(@PathParam("id") Long id) {
        Residence existingResidence = residenceDAO.getResidenceById(id);
        if (existingResidence == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Residence not found for ID: " + id)
                    .build();
        }
        try {
            residenceDAO.deleteResidence(id);
            return Response.ok("Residence deleted successfully!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error deleting residence: " + e.getMessage())
                    .build();
        }
    }
}
