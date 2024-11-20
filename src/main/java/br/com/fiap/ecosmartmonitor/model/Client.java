package br.com.fiap.ecosmartmonitor.model;

import java.util.List;

/**
 * Representa um cliente no sistema EcoSmartMonitor.
 * Contém informações pessoais e a lista de residências associadas.
 * 
 * @attributes
 * id          Identificador único do cliente.
 * name        Nome do cliente.
 * email       Email do cliente.
 * phone       Telefone do cliente.
 * address     Endereço do cliente.
 * residences  Lista de residências associadas ao cliente.
 * 
 * @constructors
 * Client() - Construtor padrão.
 * Client(Long id, String name, String email, String phone, String address, List<Residence> residences) - Construtor com todos os atributos.
 * 
 * @methods
 * Getters e Setters para todos os atributos.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public class Client {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private List<Residence> residences;

    /**
     * Construtor padrão para a classe Client.
     */
    public Client() {
        super();
    }

    /**
     * Construtor completo para inicializar todos os atributos de um cliente.
     *
     * @param id          Identificador único do cliente.
     * @param name        Nome do cliente.
     * @param email       Email do cliente.
     * @param phone       Telefone do cliente.
     * @param address     Endereço do cliente.
     * @param residences  Lista de residências associadas ao cliente.
     */
    public Client(Long id, String name, String email, String phone, String address, List<Residence> residences) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.residences = residences;
    }

    /**
     * Obtém o identificador único do cliente.
     *
     * @return ID do cliente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o identificador único do cliente.
     *
     * @param id ID do cliente.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome do cliente.
     *
     * @return Nome do cliente.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do cliente.
     *
     * @param name Nome do cliente.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o email do cliente.
     *
     * @return Email do cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do cliente.
     *
     * @param email Email do cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o telefone do cliente.
     *
     * @return Telefone do cliente.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Define o telefone do cliente.
     *
     * @param phone Telefone do cliente.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Obtém o endereço do cliente.
     *
     * @return Endereço do cliente.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Define o endereço do cliente.
     *
     * @param address Endereço do cliente.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Obtém a lista de residências associadas ao cliente.
     *
     * @return Lista de residências do cliente.
     */
    public List<Residence> getResidences() {
        return residences;
    }

    /**
     * Define a lista de residências associadas ao cliente.
     *
     * @param residences Lista de residências do cliente.
     */
    public void setResidences(List<Residence> residences) {
        this.residences = residences;
    }
}
