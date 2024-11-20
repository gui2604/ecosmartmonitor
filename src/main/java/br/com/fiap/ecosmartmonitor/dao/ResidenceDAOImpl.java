package br.com.fiap.ecosmartmonitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.ecosmartmonitor.exception.ResidenceException;
import br.com.fiap.ecosmartmonitor.model.Residence;

/**
 * Implementação da interface ResidenceDAO para acesso ao banco de dados.
 * Realiza operações CRUD na entidade Residence.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public class ResidenceDAOImpl implements ResidenceDAO {
    private Connection connection;

    /**
     * Construtor da classe ResidenceDAOImpl.
     *
     * @param connection Conexão com o banco de dados.
     */
    public ResidenceDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Insere uma nova residência no banco de dados.
     *
     * @param residence Objeto Residence contendo os dados da residência a ser inserida.
     */
    @Override
    public void createResidence(Residence residence) {
        String sql = "INSERT INTO Residence (address, client_id) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, residence.getAddress());
            stmt.setLong(2, residence.getClientId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca uma residência pelo seu ID.
     *
     * @param id ID da residência a ser buscada.
     * @return Objeto Residence correspondente ao ID informado ou null caso não seja encontrado.
     * @throws ResidenceException Caso ocorra erro ao acessar o banco de dados.
     */
    @Override
    public Residence getResidenceById(Long id) {
        String sql = "SELECT * FROM Residence WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Residence(
                        rs.getLong("id"),
                        rs.getString("address"),
                        rs.getInt("clientId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ResidenceException("Error retrieving residence with ID: " + id, e);
        }
        return null;
    }

    /**
     * Atualiza os dados de uma residência existente no banco de dados.
     *
     * @param residence Objeto Residence contendo os dados atualizados da residência.
     */
    @Override
    public void updateResidence(Residence residence) {
        String sql = "UPDATE Residence SET address = ?, client_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, residence.getAddress());
            stmt.setLong(2, residence.getClientId());
            stmt.setLong(3, residence.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta uma residência pelo seu ID.
     *
     * @param id ID da residência a ser deletada.
     */
    @Override
    public void deleteResidence(Long id) {
        String sql = "DELETE FROM Residence WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lista todas as residências cadastradas no banco de dados.
     *
     * @return Lista de objetos Residence contendo todas as residências.
     */
    @Override
    public List<Residence> getAllResidences() {
        String sql = "SELECT * FROM Residence";
        List<Residence> residences = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                residences.add(new Residence(
                        rs.getLong("id"),
                        rs.getString("address"),
                        rs.getInt("clientId")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return residences;
    }

    /**
     * Lista as residências associadas a um cliente específico.
     *
     * @param clientId ID do cliente para o qual as residências serão buscadas.
     * @return Lista de objetos Residence associados ao cliente.
     */
    @Override
    public List<Residence> getResidencesByClientId(Long clientId) {
        String sql = "SELECT * FROM Residence WHERE client_id = ?";
        List<Residence> residences = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, clientId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                residences.add(new Residence(
                        rs.getLong("id"),
                        rs.getString("address"),
                        rs.getInt("clientId")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return residences;
    }
}
