package br.com.fiap.ecosmartmonitor.model;

import java.sql.Timestamp;

/**
 * Representa um registro de consumo de energia no sistema EcoSmartMonitor.
 * Contém informações sobre o consumo, a data e hora do registro, e as associações ao dispositivo e residência.
 * 
 * @attributes
 * id            Identificador único do registro de consumo.
 * amount        Consumo em kWh.
 * timestamp     Data e hora do registro de consumo.
 * deviceId      Identificador do dispositivo associado ao consumo.
 * residenceId   Identificador da residência associada ao consumo.
 * 
 * @constructors
 * Consumption() - Construtor padrão.
 * Consumption(Long id, Double amount, Timestamp timestamp, int deviceId, int residenceId) - Construtor com todos os atributos.
 * 
 * @methods
 * Getters e Setters para todos os atributos.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public class Consumption {

    private Long id;
    private Double amount; // Consumo em kWh
    private Timestamp timestamp; // Data e hora do registro de consumo
    private int deviceId; // Associação com o dispositivo que gerou o consumo
    private int residenceId; // Associação com a residência correspondente

    /**
     * Construtor padrão para a classe Consumption.
     */
    public Consumption() {
    }

    /**
     * Construtor completo para inicializar todos os atributos de um registro de consumo.
     *
     * @param id           Identificador único do registro de consumo.
     * @param amount       Consumo em kWh.
     * @param timestamp    Data e hora do registro de consumo.
     * @param deviceId     Identificador do dispositivo associado ao consumo.
     * @param residenceId  Identificador da residência associada ao consumo.
     */
    public Consumption(Long id, Double amount, Timestamp timestamp, int deviceId, int residenceId) {
        this.id = id;
        this.amount = amount;
        this.timestamp = timestamp;
        this.deviceId = deviceId;
        this.residenceId = residenceId;
    }

    /**
     * Obtém o identificador único do registro de consumo.
     *
     * @return ID do registro de consumo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o identificador único do registro de consumo.
     *
     * @param id ID do registro de consumo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o consumo em kWh.
     *
     * @return Consumo em kWh.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Define o consumo em kWh.
     *
     * @param amount Consumo em kWh.
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Obtém a data e hora do registro de consumo.
     *
     * @return Data e hora do registro de consumo.
     */
    public Timestamp getTimeStamp() {
        return timestamp;
    }

    /**
     * Define a data e hora do registro de consumo.
     *
     * @param timestamp Data e hora do registro de consumo.
     */
    public void setTimeStamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Obtém o identificador do dispositivo associado ao consumo.
     *
     * @return ID do dispositivo associado.
     */
    public int getDeviceId() {
        return deviceId;
    }

    /**
     * Obtém o identificador da residência associada ao consumo.
     *
     * @return ID da residência associada.
     */
    public int getResidenceId() {
        return residenceId;
    }
}
