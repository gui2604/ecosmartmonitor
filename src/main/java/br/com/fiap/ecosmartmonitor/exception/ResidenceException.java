package br.com.fiap.ecosmartmonitor.exception;

/**
 * Exceção personalizada para operações relacionadas à entidade Residence.
 * Lança mensagens específicas para erros relacionados a residências.
 * 
 * @extends RuntimeException
 * @serial 4965221781116027074L
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public class ResidenceException extends RuntimeException {
    private static final long serialVersionUID = 4965221781116027074L;

    /**
     * Construtor para criar uma exceção com uma mensagem específica.
     *
     * @param message A mensagem descritiva do erro.
     */
    public ResidenceException(String message) {
        super(message);
    }

    /**
     * Construtor para criar uma exceção com uma mensagem e uma causa.
     *
     * @param message A mensagem descritiva do erro.
     * @param cause   A causa original da exceção.
     */
    public ResidenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
