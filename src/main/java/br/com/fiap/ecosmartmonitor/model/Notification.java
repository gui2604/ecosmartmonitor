package br.com.fiap.ecosmartmonitor.model;

import java.sql.Timestamp;

/**
 * Representa uma notificação no sistema EcoSmartMonitor.
 * Contém informações sobre a mensagem, a data e hora de envio, o status de leitura e o cliente associado.
 * 
 * @attributes
 * id        Identificador único da notificação.
 * message   Mensagem da notificação.
 * timestamp Data e hora do envio da notificação.
 * read      Status de leitura da notificação (e.g., "Y" para lida, "N" para não lida).
 * clientId  Identificador do cliente associado à notificação.
 * 
 * @constructors
 * Notification() - Construtor padrão.
 * Notification(Long id, String message, Timestamp timestamp, String read, int clientId) - Construtor com todos os atributos.
 * 
 * @methods
 * Getters e Setters para todos os atributos.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public class Notification {
    private Long id;
    private String message; // Mensagem da notificação
    private Timestamp timestamp; // Data e hora do envio da notificação
    private String read; // Status de leitura (e.g., "Y" para lida, "N" para não lida)
    private int clientId; // Associação com o cliente correspondente

    /**
     * Construtor padrão para a classe Notification.
     */
    public Notification() {
    }

    /**
     * Construtor completo para inicializar todos os atributos de uma notificação.
     *
     * @param id        Identificador único da notificação.
     * @param message   Mensagem da notificação.
     * @param timestamp Data e hora do envio da notificação.
     * @param read      Status de leitura da notificação (e.g., "Y" para lida, "N" para não lida).
     * @param clientId  Identificador do cliente associado à notificação.
     */
    public Notification(Long id, String message, Timestamp timestamp, String read, int clientId) {
        this.id = id;
        this.message = message;
        this.timestamp = timestamp;
        this.read = read;
        this.clientId = clientId;
    }

    /**
     * Obtém o identificador único da notificação.
     *
     * @return ID da notificação.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o identificador único da notificação.
     *
     * @param id ID da notificação.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém a mensagem da notificação.
     *
     * @return Mensagem da notificação.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Define a mensagem da notificação.
     *
     * @param message Mensagem da notificação.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Obtém a data e hora do envio da notificação.
     *
     * @return Data e hora do envio da notificação.
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Define a data e hora do envio da notificação.
     *
     * @param timestamp Data e hora do envio da notificação.
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Obtém o status de leitura da notificação.
     *
     * @return Status de leitura (e.g., "Y" para lida, "N" para não lida).
     */
    public String getRead() {
        return read;
    }

    /**
     * Define o status de leitura da notificação.
     *
     * @param read Status de leitura (e.g., "Y" para lida, "N" para não lida).
     */
    public void setLida(String read) {
        this.read = read;
    }

    /**
     * Obtém o identificador do cliente associado à notificação.
     *
     * @return ID do cliente associado.
     */
    public int getClientId() {
        return clientId;
    }
}
