package br.com.fiap.ecosmartmonitor.model;

import java.util.List;

/**
 * Representa uma residência no sistema EcoSmartMonitor.
 * Contém informações sobre o endereço, cliente associado e dispositivos conectados.
 * 
 * @attributes
 * id        Identificador único da residência.
 * address   Endereço da residência.
 * clientId  Identificador do cliente associado à residência.
 * devices   Lista de dispositivos conectados à residência.
 * 
 * @constructors
 * Residence() - Construtor padrão.
 * Residence(Long id, String address, int clientId) - Construtor para inicializar atributos básicos.
 * Residence(Long id, String address, int clientId, List<Device> devices) - Construtor completo.
 * 
 * @methods
 * Getters e Setters para todos os atributos.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public class Residence {

    private Long id;
    private String address; // Endereço da residência
    private int clientId; // Identificador do cliente associado à residência
    private List<Device> devices; // Lista de dispositivos conectados à residência

    /**
     * Construtor padrão para a classe Residence.
     */
    public Residence() {
    }

    /**
     * Construtor para inicializar os atributos básicos de uma residência.
     *
     * @param id       Identificador único da residência.
     * @param address  Endereço da residência.
     * @param clientId Identificador do cliente associado à residência.
     */
    public Residence(Long id, String address, int clientId) {
        super();
        this.id = id;
        this.address = address;
        this.clientId = clientId;
    }

    /**
     * Construtor completo para inicializar todos os atributos de uma residência.
     *
     * @param id       Identificador único da residência.
     * @param address  Endereço da residência.
     * @param clientId Identificador do cliente associado à residência.
     * @param devices  Lista de dispositivos conectados à residência.
     */
    public Residence(Long id, String address, int clientId, List<Device> devices) {
        this.id = id;
        this.address = address;
        this.clientId = clientId;
        this.devices = devices;
    }

    /**
     * Obtém o identificador único da residência.
     *
     * @return ID da residência.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o identificador único da residência.
     *
     * @param id ID da residência.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o endereço da residência.
     *
     * @return Endereço da residência.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Define o endereço da residência.
     *
     * @param address Endereço da residência.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Obtém o identificador do cliente associado à residência.
     *
     * @return ID do cliente associado.
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Define o identificador do cliente associado à residência.
     *
     * @param clientId ID do cliente associado.
     */
    public void setClient(int clientId) {
        this.clientId = clientId;
    }

    /**
     * Obtém a lista de dispositivos conectados à residência.
     *
     * @return Lista de dispositivos conectados.
     */
    public List<Device> getDispositivos() {
        return devices;
    }

    /**
     * Define a lista de dispositivos conectados à residência.
     *
     * @param devices Lista de dispositivos conectados.
     */
    public void setDispositivos(List<Device> devices) {
        this.devices = devices;
    }
}
