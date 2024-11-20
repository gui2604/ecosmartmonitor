package br.com.fiap.ecosmartmonitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.ecosmartmonitor.exception.NotificationException;
import br.com.fiap.ecosmartmonitor.model.Notification;

/**
 * Implementação da interface NotificationDAO para acesso ao banco de dados.
 * Realiza operações CRUD na entidade Notification e marca notificações como lidas.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public class NotificationDAOImpl implements NotificationDAO {
    private Connection connection;

    /**
     * Construtor da classe NotificationDAOImpl.
     *
     * @param connection Conexão com o banco de dados.
     */
    public NotificationDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Insere uma nova notificação no banco de dados.
     *
     * @param notification Objeto Notification contendo os dados da notificação a ser inserida.
     */
    @Override
    public void createNotification(Notification notification) {
        String sql = "INSERT INTO Notification (message, timestamp, read, client_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, notification.getMessage());
            stmt.setTimestamp(2, notification.getTimestamp());
            stmt.setString(3, notification.getRead());
            stmt.setInt(4, notification.getClientId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca uma notificação pelo seu ID.
     *
     * @param id ID da notificação a ser buscada.
     * @return Objeto Notification correspondente ao ID informado ou null caso não seja encontrado.
     * @throws NotificationException Caso ocorra erro ao acessar o banco de dados.
     */
    @Override
    public Notification getNotificationById(Long id) {
        String sql = "SELECT * FROM Notification WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Notification(
                        rs.getLong("id"),
                        rs.getString("message"),
                        rs.getTimestamp("timestamp"),
                        rs.getString("read"),
                        rs.getInt("clientId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NotificationException("Error retrieving notification with ID: " + id, e);
        }
        return null;
    }

    /**
     * Atualiza os dados de uma notificação existente no banco de dados.
     *
     * @param notification Objeto Notification contendo os dados atualizados da notificação.
     */
    @Override
    public void updateNotification(Notification notification) {
        String sql = "UPDATE Notification SET message = ?, timestamp = ?, read = ?, client_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, notification.getMessage());
            stmt.setTimestamp(2, notification.getTimestamp());
            stmt.setString(3, notification.getRead());
            stmt.setLong(4, notification.getClientId());
            stmt.setLong(5, notification.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta uma notificação pelo seu ID.
     *
     * @param id ID da notificação a ser deletada.
     */
    @Override
    public void deleteNotification(Long id) {
        String sql = "DELETE FROM Notification WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lista todas as notificações cadastradas no banco de dados.
     *
     * @return Lista de objetos Notification contendo todas as notificações.
     */
    @Override
    public List<Notification> getAllNotifications() {
        String sql = "SELECT * FROM Notification";
        List<Notification> notifications = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                notifications.add(new Notification(
                        rs.getLong("id"),
                        rs.getString("message"),
                        rs.getTimestamp("timestamp"),
                        rs.getString("read"),
                        rs.getInt("clientId")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notifications;
    }

    /**
     * Lista as notificações associadas a um cliente específico.
     *
     * @param clientId ID do cliente para o qual as notificações serão buscadas.
     * @return Lista de objetos Notification associados ao cliente.
     */
    @Override
    public List<Notification> getNotificationsByClientId(Long clientId) {
        String sql = "SELECT * FROM Notification WHERE client_id = ?";
        List<Notification> notifications = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, clientId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                notifications.add(new Notification(
                        rs.getLong("id"),
                        rs.getString("message"),
                        rs.getTimestamp("timestamp"),
                        rs.getString("read"),
                        rs.getInt("clientId")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notifications;
    }

    /**
     * Marca uma notificação como lida.
     *
     * @param id ID da notificação a ser marcada como lida.
     */
    @Override
    public void markAsRead(Long id) {
        String sql = "UPDATE Notification SET read = 'Y' WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Notification with ID " + id + " marked as read.");
            } else {
                System.out.println("No notification found with ID " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
