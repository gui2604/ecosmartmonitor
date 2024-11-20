package br.com.fiap.ecosmartmonitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.ecosmartmonitor.exception.ClientException;
import br.com.fiap.ecosmartmonitor.model.Client;

/**
 * Implementação da interface ClientDAO para acesso ao banco de dados.
 * Realiza operações CRUD na entidade Client.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public class ClientDAOImpl implements ClientDAO {
    private Connection connection;

    /**
     * Construtor da classe ClientDAOImpl.
     *
     * @param connection Conexão com o banco de dados.
     */
    public ClientDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Insere um novo cliente no banco de dados.
     *
     * @param client Objeto Client contendo os dados do cliente a ser inserido.
     */
    @Override
    public void createClient(Client client) {
        String sql = "INSERT INTO Client (name, email, phone, address) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getEmail());
            stmt.setString(3, client.getPhone());
            stmt.setString(4, client.getAddress());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca um cliente pelo ID.
     *
     * @param id ID do cliente a ser buscado.
     * @return Objeto Client correspondente ao ID informado ou null caso não seja encontrado.
     * @throws ClientException Caso ocorra erro ao acessar o banco de dados.
     */
    @Override
    public Client getClientById(Long id) {
        String sql = "SELECT * FROM Client WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Client(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"), null
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ClientException("Error retrieving client with ID: " + id, e);
        }
        return null;
    }

    /**
     * Atualiza os dados de um cliente existente no banco de dados.
     *
     * @param client Objeto Client contendo os dados atualizados do cliente.
     */
    @Override
    public void updateClient(Client client) {
        String sql = "UPDATE Client SET name = ?, email = ?, phone = ?, address = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getEmail());
            stmt.setString(3, client.getPhone());
            stmt.setString(4, client.getAddress());
            stmt.setLong(5, client.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta um cliente pelo ID.
     *
     * @param id ID do cliente a ser deletado.
     */
    @Override
    public void deleteClient(Long id) {
        String sql = "DELETE FROM Client WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lista todos os clientes cadastrados no banco de dados.
     *
     * @return Lista de objetos Client contendo todos os clientes.
     */
    @Override
    public List<Client> getAllClients() {
        String sql = "SELECT * FROM Client";
        List<Client> clients = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                clients.add(new Client(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"), null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
}
