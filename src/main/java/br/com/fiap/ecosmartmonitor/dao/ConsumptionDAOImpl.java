package br.com.fiap.ecosmartmonitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.ecosmartmonitor.exception.ConsumptionException;
import br.com.fiap.ecosmartmonitor.model.Consumption;

/**
 * Implementação da interface ConsumptionDAO para acesso ao banco de dados.
 * Realiza operações CRUD na entidade Consumption.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public class ConsumptionDAOImpl implements ConsumptionDAO {
    private Connection connection;

    /**
     * Construtor da classe ConsumptionDAOImpl.
     *
     * @param connection Conexão com o banco de dados.
     */
    public ConsumptionDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Insere um novo registro de consumo no banco de dados.
     *
     * @param consumption Objeto Consumption contendo os dados do registro a ser inserido.
     */
    @Override
    public void createConsumption(Consumption consumption) {
        String sql = "INSERT INTO Consumption (amount, timestamp, device_id, residence_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, consumption.getAmount());
            stmt.setTimestamp(2, consumption.getTimeStamp());
            stmt.setInt(3, consumption.getDeviceId());
            stmt.setInt(4, consumption.getResidenceId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca um registro de consumo pelo seu ID.
     *
     * @param id ID do registro de consumo a ser buscado.
     * @return Objeto Consumption correspondente ao ID informado ou null caso não seja encontrado.
     * @throws ConsumptionException Caso ocorra erro ao acessar o banco de dados.
     */
    @Override
    public Consumption getConsumptionById(Long id) {
        String sql = "SELECT * FROM Consumption WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Consumption(
                        rs.getLong("id"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("timestamp"),
                        rs.getInt("device_id"),
                        rs.getInt("residence_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ConsumptionException("Error retrieving consumption with ID: " + id, e);
        }
        return null;
    }

    /**
     * Atualiza os dados de um registro de consumo existente no banco de dados.
     *
     * @param consumption Objeto Consumption contendo os dados atualizados do registro.
     */
    @Override
    public void updateConsumption(Consumption consumption) {
        String sql = "UPDATE Consumption SET amount = ?, timestamp = ?, device_id = ?, residence_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, consumption.getAmount());
            stmt.setTimestamp(2, consumption.getTimeStamp());
            stmt.setInt(3, consumption.getDeviceId());
            stmt.setInt(4, consumption.getResidenceId());
            stmt.setLong(5, consumption.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta um registro de consumo pelo seu ID.
     *
     * @param id ID do registro de consumo a ser deletado.
     */
    @Override
    public void deleteConsumption(Long id) {
        String sql = "DELETE FROM Consumption WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lista todos os registros de consumo cadastrados no banco de dados.
     *
     * @return Lista de objetos Consumption contendo todos os registros.
     */
    @Override
    public List<Consumption> getAllConsumptions() {
        String sql = "SELECT * FROM Consumption";
        List<Consumption> consumptions = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                consumptions.add(new Consumption(
                        rs.getLong("id"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("timestamp"),
                        rs.getInt("device_id"),
                        rs.getInt("residence_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consumptions;
    }

    /**
     * Lista os registros de consumo associados a um dispositivo específico.
     *
     * @param deviceId ID do dispositivo para o qual os registros de consumo serão buscados.
     * @return Lista de objetos Consumption associados ao dispositivo.
     */
    @Override
    public List<Consumption> getConsumptionsByDeviceId(Long deviceId) {
        String sql = "SELECT * FROM Consumption WHERE device_id = ?";
        List<Consumption> consumptions = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, deviceId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                consumptions.add(new Consumption(
                        rs.getLong("id"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("timestamp"),
                        rs.getInt("device_id"),
                        rs.getInt("residence_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consumptions;
    }

    /**
     * Lista os registros de consumo associados a uma residência específica.
     *
     * @param residenceId ID da residência para a qual os registros de consumo serão buscados.
     * @return Lista de objetos Consumption associados à residência.
     */
    @Override
    public List<Consumption> getConsumptionsByResidenceId(Long residenceId) {
        String sql = "SELECT * FROM Consumption WHERE residence_id = ?";
        List<Consumption> consumptions = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, residenceId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                consumptions.add(new Consumption(
                        rs.getLong("id"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("timestamp"),
                        rs.getInt("device_id"),
                        rs.getInt("residence_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consumptions;
    }
}
