package br.com.fiap.ecosmartmonitor.exception;

/**
 * Exceção personalizada para operações relacionadas à entidade Notification.
 * Lança mensagens específicas para erros relacionados a notificações.
 * 
 * @extends RuntimeException
 * @serial -398760616943996753L
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public class NotificationException extends RuntimeException {
    private static final long serialVersionUID = -398760616943996753L;

    /**
     * Construtor para criar uma exceção com uma mensagem específica.
     *
     * @param message A mensagem descritiva do erro.
     */
    public NotificationException(String message) {
        super(message);
    }

    /**
     * Construtor para criar uma exceção com uma mensagem e uma causa.
     *
     * @param message A mensagem descritiva do erro.
     * @param cause   A causa original da exceção.
     */
    public NotificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
