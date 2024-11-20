package br.com.fiap.ecosmartmonitor.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.ecosmartmonitor.dao.NotificationDAO;
import br.com.fiap.ecosmartmonitor.factory.DAOFactory;
import br.com.fiap.ecosmartmonitor.model.Notification;
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
 * Controlador responsável por gerenciar as operações relacionadas às notificações.
 * Proporciona endpoints RESTful para CRUD e operações específicas das notificações.
 *
 * Base URL: /notifications
 *
 * @produces MediaType.APPLICATION_JSON - Respostas no formato JSON.
 * @consumes MediaType.APPLICATION_JSON - Requisições com corpo em formato JSON.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
@Path("/notifications")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotificationController {

    private final NotificationDAO notificationDAO;

    /**
     * Construtor da classe NotificationController.
     * Inicializa o DAO de notificações utilizando a fábrica DAO.
     *
     * @throws SQLException caso ocorra erro na conexão com o banco de dados.
     */
    public NotificationController() throws SQLException {
        this.notificationDAO = DAOFactory.getNotificationDAO();
    }

    /**
     * Recupera uma notificação específica pelo ID.
     *
     * @param id ID da notificação a ser buscada.
     * @return Response com a notificação encontrada ou erro caso não exista.
     */
    @GET
    @Path("/{id}")
    public Response getNotificationById(@PathParam("id") Long id) {
        Notification notification = notificationDAO.getNotificationById(id);
        if (notification != null) {
            return Response.ok(notification).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Notification not found for ID: " + id)
                    .build();
        }
    }

    /**
     * Recupera todas as notificações de um cliente específico.
     *
     * @param clientId ID do cliente para o qual as notificações serão buscadas.
     * @return Response com a lista de notificações encontradas ou erro caso não existam notificações.
     */
    @GET
    @Path("/client/{clientId}")
    public Response getNotificationsByClientId(@PathParam("clientId") Long clientId) {
        List<Notification> notifications = notificationDAO.getNotificationsByClientId(clientId);
        if (notifications != null && !notifications.isEmpty()) {
            return Response.ok(notifications).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No notifications found for client ID: " + clientId)
                    .build();
        }
    }

    /**
     * Cria uma nova notificação.
     *
     * @param notification Objeto Notification com os dados da notificação a ser criada.
     * @return Response indicando o sucesso ou erro na criação.
     */
    @POST
    public Response createNotification(Notification notification) {
        try {
            notificationDAO.createNotification(notification);
            return Response.status(Response.Status.CREATED)
                    .entity("Notification created successfully!")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error creating notification: " + e.getMessage())
                    .build();
        }
    }

    /**
     * Marca uma notificação específica como lida.
     *
     * @param id ID da notificação a ser marcada como lida.
     * @return Response indicando o sucesso ou erro na operação.
     */
    @PUT
    @Path("/{id}/mark-as-read")
    public Response markNotificationAsRead(@PathParam("id") Long id) {
        Notification existingNotification = notificationDAO.getNotificationById(id);
        if (existingNotification == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Notification not found for ID: " + id)
                    .build();
        }
        try {
            notificationDAO.markAsRead(id);
            return Response.ok("Notification marked as read successfully!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error marking notification as read: " + e.getMessage())
                    .build();
        }
    }

    /**
     * Exclui uma notificação existente pelo ID.
     *
     * @param id ID da notificação a ser excluída.
     * @return Response indicando o sucesso ou erro na exclusão.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteNotification(@PathParam("id") Long id) {
        Notification existingNotification = notificationDAO.getNotificationById(id);
        if (existingNotification == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Notification not found for ID: " + id)
                    .build();
        }
        try {
            notificationDAO.deleteNotification(id);
            return Response.ok("Notification deleted successfully!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error deleting notification: " + e.getMessage())
                    .build();
        }
    }
}
