package br.com.fiap.ecosmartmonitor.exception;

/**
 * Exceção personalizada para operações relacionadas à entidade Consumption.
 * Lança mensagens específicas para erros relacionados a consumos.
 * 
 * @extends RuntimeException
 * @serial 4437354501312814475L
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public class ConsumptionException extends RuntimeException {
    private static final long serialVersionUID = -4437354501312814475L;

    /**
     * Construtor para criar uma exceção com uma mensagem específica.
     *
     * @param message A mensagem descritiva do erro.
     */
    public ConsumptionException(String message) {
        super(message);
    }

    /**
     * Construtor para criar uma exceção com uma mensagem e uma causa.
     *
     * @param message A mensagem descritiva do erro.
     * @param cause   A causa original da exceção.
     */
    public ConsumptionException(String message, Throwable cause) {
        super(message, cause);
    }
}
