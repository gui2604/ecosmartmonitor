package br.com.fiap.ecosmartmonitor.exception;

/**
 * Exceção personalizada para operações relacionadas à entidade Device.
 * Lança mensagens específicas para erros relacionados a dispositivos.
 * 
 * @extends RuntimeException
 * @serial -8782547908367542895L
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public class DeviceException extends RuntimeException {
    private static final long serialVersionUID = -8782547908367542895L;

    /**
     * Construtor para criar uma exceção com uma mensagem específica.
     *
     * @param message A mensagem descritiva do erro.
     */
    public DeviceException(String message) {
        super(message);
    }

    /**
     * Construtor para criar uma exceção com uma mensagem e uma causa.
     *
     * @param message A mensagem descritiva do erro.
     * @param cause   A causa original da exceção.
     */
    public DeviceException(String message, Throwable cause) {
        super(message, cause);
    }
}
