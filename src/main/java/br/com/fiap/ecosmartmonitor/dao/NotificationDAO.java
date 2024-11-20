package br.com.fiap.ecosmartmonitor.dao;

import java.util.List;

import br.com.fiap.ecosmartmonitor.model.Notification;

/**
 * Interface para operações de acesso a dados relacionadas à entidade Notification.
 * Define métodos para manipulação das notificações no banco de dados.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public interface NotificationDAO {

    /**
     * Insere uma nova notificação no banco de dados.
     *
     * @param notification Objeto Notification contendo os dados da notificação a ser inserida.
     */
    void createNotification(Notification notification);

    /**
     * Busca uma notificação pelo seu ID.
     *
     * @param id ID da notificação a ser buscada.
     * @return Objeto Notification correspondente ao ID informado ou null caso não seja encontrado.
     */
    Notification getNotificationById(Long id);

    /**
     * Atualiza os dados de uma notificação existente no banco de dados.
     *
     * @param notification Objeto Notification contendo os dados atualizados da notificação.
     */
    void updateNotification(Notification notification);

    /**
     * Deleta uma notificação pelo seu ID.
     *
     * @param id ID da notificação a ser deletada.
     */
    void deleteNotification(Long id);

    /**
     * Lista todas as notificações cadastradas no banco de dados.
     *
     * @return Lista de objetos Notification contendo todas as notificações.
     */
    List<Notification> getAllNotifications();

    /**
     * Lista as notificações associadas a um cliente específico.
     *
     * @param clientId ID do cliente para o qual as notificações serão buscadas.
     * @return Lista de objetos Notification associados ao cliente.
     */
    List<Notification> getNotificationsByClientId(Long clientId);

    /**
     * Marca uma notificação como lida.
     *
     * @param id ID da notificação a ser marcada como lida.
     */
    void markAsRead(Long id);
}
