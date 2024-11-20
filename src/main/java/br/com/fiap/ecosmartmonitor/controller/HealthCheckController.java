package br.com.fiap.ecosmartmonitor.controller;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.ecosmartmonitor.util.ConnectionDB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Controlador responsável por verificar a saúde do servidor e do banco de dados.
 * Proporciona endpoints para health check, permitindo monitorar o status da aplicação.
 *
 * Base URL: /
 *
 * @produces MediaType.APPLICATION_JSON - Respostas no formato JSON.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class HealthCheckController {

    /**
     * Health Check Simples: Verifica apenas o status do servidor.
     * 
     * Endpoint: GET /healthcheck
     * 
     * @return Response com o status do servidor no formato JSON.
     *         Exemplo: {"status":"UP"}
     */
    @GET
    @Path("healthcheck")
    public Response simpleHealthCheck() {
        return Response.ok("{\"status\":\"UP\"}").build();
    }

    /**
     * Health Check Completo: Verifica o status do servidor e a conexão com o banco de dados.
     * 
     * Endpoint: GET /fullhealthcheck
     * 
     * @return Response com o status do servidor e do banco de dados no formato JSON.
     *         Exemplo em caso de sucesso: {"status":"UP","database":"CONNECTED"}
     *         Exemplo em caso de falha: {"status":"DOWN","database":"DISCONNECTED"}
     *         Exemplo em caso de erro: {"status":"DOWN","database":"ERROR","message":"<mensagem de erro>"}
     */
    @GET
    @Path("fullhealthcheck")
    public Response fullHealthCheck() {
        try (Connection connection = ConnectionDB.getInstance().getConnection()) {
            if (connection != null && !connection.isClosed()) {
                return Response.ok("{\"status\":\"UP\",\"database\":\"CONNECTED\"}").build();
            } else {
                return Response.status(Response.Status.SERVICE_UNAVAILABLE)
                        .entity("{\"status\":\"DOWN\",\"database\":\"DISCONNECTED\"}")
                        .build();
            }
        } catch (SQLException e) {
            return Response.status(Response.Status.SERVICE_UNAVAILABLE)
                    .entity("{\"status\":\"DOWN\",\"database\":\"ERROR\",\"message\":\"" + e.getMessage() + "\"}")
                    .build();
        }
    }
}
