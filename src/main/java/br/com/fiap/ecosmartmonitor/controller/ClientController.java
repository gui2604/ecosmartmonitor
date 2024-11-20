package br.com.fiap.ecosmartmonitor.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.ecosmartmonitor.dao.ClientDAO;
import br.com.fiap.ecosmartmonitor.factory.DAOFactory;
import br.com.fiap.ecosmartmonitor.model.Client;
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
 * Controlador responsável por gerenciar as operações relacionadas a clientes.
 * Proporciona endpoints RESTful para CRUD de clientes.
 *
 * Base URL: /clients
 *
 * @produces MediaType.APPLICATION_JSON - Respostas no formato JSON.
 * @consumes MediaType.APPLICATION_JSON - Requisições com corpo em formato JSON.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientController {

    private ClientDAO clientDAO;

    /**
     * Construtor da classe ClientController.
     * Inicializa o DAO de cliente utilizando a fábrica DAO.
     *
     * @throws SQLException caso ocorra erro na conexão com o banco de dados.
     */
    public ClientController() throws SQLException {
        this.clientDAO = DAOFactory.getClientDAO();
    }

    /**
     * Recupera todos os clientes cadastrados.
     *
     * @return Response com a lista de clientes ou um erro caso a operação falhe.
     */
    @GET
    public Response getAllClients() {
        try {
            List<Client> clients = clientDAO.getAllClients();
            return Response.ok(clients).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error retrieving clients: " + e.getMessage())
                           .build();
        }
    }

    /**
     * Recupera um cliente específico pelo ID.
     *
     * @param id ID do cliente a ser buscado.
     * @return Response com o cliente encontrado ou erro caso não exista ou a operação falhe.
     */
    @GET
    @Path("/{id}")
    public Response getClientById(@PathParam("id") Long id) {
        try {
            Client client = clientDAO.getClientById(id);
            if (client == null) {
                return Response.status(Response.Status.NOT_FOUND)
                               .entity("Client not found")
                               .build();
            }
            return Response.ok(client).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error retrieving client: " + e.getMessage())
                           .build();
        }
    }

    /**
     * Cria um novo cliente.
     *
     * @param client Objeto Client com os dados do cliente a ser criado.
     * @return Response indicando o sucesso ou erro na criação.
     */
    @POST
    public Response createClient(Client client) {
        try {
            clientDAO.createClient(client);
            return Response.status(Response.Status.CREATED)
                           .entity("Client created successfully")
                           .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error creating client: " + e.getMessage())
                           .build();
        }
    }

    /**
     * Atualiza um cliente existente pelo ID.
     *
     * @param id     ID do cliente a ser atualizado.
     * @param client Objeto Client com os novos dados do cliente.
     * @return Response indicando o sucesso ou erro na atualização.
     */
    @PUT
    @Path("/{id}")
    public Response updateClient(@PathParam("id") Long id, Client client) {
        try {
            Client existingClient = clientDAO.getClientById(id);
            if (existingClient == null) {
                return Response.status(Response.Status.NOT_FOUND)
                               .entity("Client not found")
                               .build();
            }
            client.setId(id); // Garantir que o ID é o mesmo do cliente a ser atualizado
            clientDAO.updateClient(client);
            return Response.ok("Client updated successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error updating client: " + e.getMessage())
                           .build();
        }
    }

    /**
     * Exclui um cliente existente pelo ID.
     *
     * @param id ID do cliente a ser excluído.
     * @return Response indicando o sucesso ou erro na exclusão.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteClient(@PathParam("id") Long id) {
        try {
            Client existingClient = clientDAO.getClientById(id);
            if (existingClient == null) {
                return Response.status(Response.Status.NOT_FOUND)
                               .entity("Client not found")
                               .build();
            }
            clientDAO.deleteClient(id);
            return Response.ok("Client deleted successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error deleting client: " + e.getMessage())
                           .build();
        }
    }
}
