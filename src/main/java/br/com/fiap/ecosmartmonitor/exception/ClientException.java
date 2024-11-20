package br.com.fiap.ecosmartmonitor.exception;

/**
 * Exceção personalizada para operações relacionadas à entidade Client.
 * Lança mensagens específicas para erros relacionados a clientes.
 * 
 * @extends RuntimeException
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public class ClientException extends RuntimeException {
    private static final long serialVersionUID = 3935242020655452885L;

    /**
     * Construtor para criar uma exceção com uma mensagem específica.
     *
     * @param message A mensagem descritiva do erro.
     */
    public ClientException(String message) {
        super(message);
    }

    /**
     * Construtor para criar uma exceção com uma mensagem e uma causa.
     *
     * @param message A mensagem descritiva do erro.
     * @param cause   A causa original da exceção.
     */
    public ClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
