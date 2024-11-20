package br.com.fiap.ecosmartmonitor.dao;

import java.util.List;

import br.com.fiap.ecosmartmonitor.model.Device;

/**
 * Interface para operações de acesso a dados relacionadas à entidade Device.
 * Define métodos para manipulação dos dispositivos no banco de dados.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public interface DeviceDAO {

    /**
     * Insere um novo dispositivo no banco de dados.
     *
     * @param device Objeto Device contendo os dados do dispositivo a ser inserido.
     */
    void createDevice(Device device);

    /**
     * Busca um dispositivo pelo seu ID.
     *
     * @param id ID do dispositivo a ser buscado.
     * @return Objeto Device correspondente ao ID informado ou null caso não seja encontrado.
     */
    Device getDeviceById(Long id);

    /**
     * Atualiza os dados de um dispositivo existente no banco de dados.
     *
     * @param device Objeto Device contendo os dados atualizados do dispositivo.
     */
    void updateDevice(Device device);

    /**
     * Deleta um dispositivo pelo seu ID.
     *
     * @param id ID do dispositivo a ser deletado.
     */
    void deleteDevice(Long id);

    /**
     * Lista todos os dispositivos cadastrados no banco de dados.
     *
     * @return Lista de objetos Device contendo todos os dispositivos.
     */
    List<Device> getAllDevices();

    /**
     * Lista os dispositivos associados a uma residência específica.
     *
     * @param residenceId ID da residência para a qual os dispositivos serão buscados.
     * @return Lista de objetos Device associados à residência.
     */
    List<Device> getDevicesByResidenceId(Long residenceId);
}
