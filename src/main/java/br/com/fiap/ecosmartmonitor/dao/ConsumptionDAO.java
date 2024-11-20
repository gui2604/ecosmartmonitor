package br.com.fiap.ecosmartmonitor.dao;

import java.util.List;

import br.com.fiap.ecosmartmonitor.model.Consumption;

/**
 * Interface para operações de acesso a dados relacionadas à entidade Consumption.
 * Define métodos para manipulação dos registros de consumo no banco de dados.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public interface ConsumptionDAO {

    /**
     * Insere um novo registro de consumo no banco de dados.
     *
     * @param consumption Objeto Consumption contendo os dados do registro de consumo a ser inserido.
     */
    void createConsumption(Consumption consumption);

    /**
     * Busca um registro de consumo pelo seu ID.
     *
     * @param id ID do registro de consumo a ser buscado.
     * @return Objeto Consumption correspondente ao ID informado ou null caso não seja encontrado.
     */
    Consumption getConsumptionById(Long id);

    /**
     * Atualiza os dados de um registro de consumo existente no banco de dados.
     *
     * @param consumption Objeto Consumption contendo os dados atualizados do registro de consumo.
     */
    void updateConsumption(Consumption consumption);

    /**
     * Deleta um registro de consumo pelo seu ID.
     *
     * @param id ID do registro de consumo a ser deletado.
     */
    void deleteConsumption(Long id);

    /**
     * Lista todos os registros de consumo cadastrados no banco de dados.
     *
     * @return Lista de objetos Consumption contendo todos os registros de consumo.
     */
    List<Consumption> getAllConsumptions();

    /**
     * Lista os registros de consumo associados a um dispositivo específico.
     *
     * @param deviceId ID do dispositivo para o qual os registros de consumo serão buscados.
     * @return Lista de objetos Consumption associados ao dispositivo.
     */
    List<Consumption> getConsumptionsByDeviceId(Long deviceId);

    /**
     * Lista os registros de consumo associados a uma residência específica.
     *
     * @param residenceId ID da residência para a qual os registros de consumo serão buscados.
     * @return Lista de objetos Consumption associados à residência.
     */
    List<Consumption> getConsumptionsByResidenceId(Long residenceId);
}
