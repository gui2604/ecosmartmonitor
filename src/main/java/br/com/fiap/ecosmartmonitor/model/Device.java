package br.com.fiap.ecosmartmonitor.model;

/**
 * Representa um dispositivo no sistema EcoSmartMonitor.
 * Contém informações sobre o dispositivo, seu tipo, consumo médio e associação com uma residência.
 * 
 * @attributes
 * id                 Identificador único do dispositivo.
 * name               Nome do dispositivo.
 * type               Tipo do dispositivo (e.g., eletrodoméstico, iluminação).
 * averageConsumption Consumo médio do dispositivo em kWh.
 * residenceId        Identificador da residência associada ao dispositivo.
 * 
 * @constructors
 * Device() - Construtor padrão.
 * Device(Long id, String name, String type, Double averageConsumption, int residenceId) - Construtor com todos os atributos.
 * 
 * @methods
 * Getters e Setters para todos os atributos.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public class Device {

    private Long id;
    private String name; // Nome do dispositivo
    private String type; // Tipo do dispositivo (e.g., eletrodoméstico, iluminação)
    private Double averageConsumption; // Consumo médio em kWh
    private int residenceId; // Associação com a residência a que pertence

    /**
     * Construtor padrão para a classe Device.
     */
    public Device() {
    }

    /**
     * Construtor completo para inicializar todos os atributos de um dispositivo.
     *
     * @param id                 Identificador único do dispositivo.
     * @param name               Nome do dispositivo.
     * @param type               Tipo do dispositivo (e.g., eletrodoméstico, iluminação).
     * @param averageConsumption Consumo médio do dispositivo em kWh.
     * @param residenceId        Identificador da residência associada ao dispositivo.
     */
    public Device(Long id, String name, String type, Double averageConsumption, int residenceId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.averageConsumption = averageConsumption;
        this.residenceId = residenceId;
    }

    /**
     * Obtém o identificador único do dispositivo.
     *
     * @return ID do dispositivo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o identificador único do dispositivo.
     *
     * @param id ID do dispositivo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome do dispositivo.
     *
     * @return Nome do dispositivo.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do dispositivo.
     *
     * @param name Nome do dispositivo.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o tipo do dispositivo.
     *
     * @return Tipo do dispositivo (e.g., eletrodoméstico, iluminação).
     */
    public String getType() {
        return type;
    }

    /**
     * Define o tipo do dispositivo.
     *
     * @param type Tipo do dispositivo (e.g., eletrodoméstico, iluminação).
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Obtém o consumo médio do dispositivo em kWh.
     *
     * @return Consumo médio do dispositivo em kWh.
     */
    public Double getAverageConsumption() {
        return averageConsumption;
    }

    /**
     * Define o consumo médio do dispositivo em kWh.
     *
     * @param averageConsumption Consumo médio do dispositivo em kWh.
     */
    public void setAverageConsumption(Double averageConsumption) {
        this.averageConsumption = averageConsumption;
    }

    /**
     * Obtém o identificador da residência associada ao dispositivo.
     *
     * @return ID da residência associada ao dispositivo.
     */
    public int getResidenceId() {
        return residenceId;
    }
}
