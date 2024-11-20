package br.com.fiap.ecosmartmonitor.dao;

import java.util.List;

import br.com.fiap.ecosmartmonitor.model.Residence;

/**
 * Interface para operações de acesso a dados relacionadas à entidade Residence.
 * Define métodos para manipulação das residências no banco de dados.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public interface ResidenceDAO {

    /**
     * Insere uma nova residência no banco de dados.
     *
     * @param residence Objeto Residence contendo os dados da residência a ser inserida.
     */
    void createResidence(Residence residence);

    /**
     * Busca uma residência pelo seu ID.
     *
     * @param id ID da residência a ser buscada.
     * @return Objeto Residence correspondente ao ID informado ou null caso não seja encontrado.
     */
    Residence getResidenceById(Long id);

    /**
     * Atualiza os dados de uma residência existente no banco de dados.
     *
     * @param residence Objeto Residence contendo os dados atualizados da residência.
     */
    void updateResidence(Residence residence);

    /**
     * Deleta uma residência pelo seu ID.
     *
     * @param id ID da residência a ser deletada.
     */
    void deleteResidence(Long id);

    /**
     * Lista todas as residências cadastradas no banco de dados.
     *
     * @return Lista de objetos Residence contendo todas as residências.
     */
    List<Residence> getAllResidences();

    /**
     * Lista as residências associadas a um cliente específico.
     *
     * @param clientId ID do cliente para o qual as residências serão buscadas.
     * @return Lista de objetos Residence associados ao cliente.
     */
    List<Residence> getResidencesByClientId(Long clientId);
}
