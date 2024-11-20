package br.com.fiap.ecosmartmonitor.dao;

import java.util.List;
import br.com.fiap.ecosmartmonitor.model.Client;

/**
 * Interface para operações de acesso a dados relacionadas à entidade Client.
 * Define métodos para manipulação de clientes no banco de dados.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public interface ClientDAO {

    /**
     * Insere um novo cliente no banco de dados.
     *
     * @param client Objeto Client contendo os dados do cliente a ser inserido.
     */
    void createClient(Client client);

    /**
     * Busca um cliente pelo seu ID.
     *
     * @param id ID do cliente a ser buscado.
     * @return Client correspondente ao ID informado ou null caso não seja encontrado.
     */
    Client getClientById(Long id);

    /**
     * Atualiza os dados de um cliente existente.
     *
     * @param client Objeto Client contendo os dados atualizados do cliente.
     */
    void updateClient(Client client);

    /**
     * Deleta um cliente pelo seu ID.
     *
     * @param id ID do cliente a ser deletado.
     */
    void deleteClient(Long id);

    /**
     * Lista todos os clientes cadastrados no banco de dados.
     *
     * @return Lista de objetos Client contendo todos os clientes.
     */
    List<Client> getAllClients();
}
