package br.com.fiap.ecosmartmonitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.ecosmartmonitor.exception.DeviceException;
import br.com.fiap.ecosmartmonitor.model.Device;

/**
 * Implementação da interface DeviceDAO para acesso ao banco de dados.
 * Realiza operações CRUD na entidade Device.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public class DeviceDAOImpl implements DeviceDAO {
    private Connection connection;

    /**
     * Construtor da classe DeviceDAOImpl.
     *
     * @param connection Conexão com o banco de dados.
     */
    public DeviceDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Insere um novo dispositivo no banco de dados.
     *
     * @param device Objeto Device contendo os dados do dispositivo a ser inserido.
     */
    @Override
    public void createDevice(Device device) {
        String sql = "INSERT INTO Device (name, type, status, residence_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, device.getName());
            stmt.setString(2, device.getType());
            stmt.setDouble(3, device.getAverageConsumption());
            stmt.setLong(4, device.getResidenceId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca um dispositivo pelo seu ID.
     *
     * @param id ID do dispositivo a ser buscado.
     * @return Objeto Device correspondente ao ID informado ou null caso não seja encontrado.
     * @throws DeviceException Caso ocorra erro ao acessar o banco de dados.
     */
    @Override
    public Device getDeviceById(Long id) {
        String sql = "SELECT * FROM Device WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Device(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getDouble("averageConsumption"),
                        rs.getInt("residenceId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DeviceException("Error retrieving device with ID: " + id, e);
        }
        return null;
    }

    /**
     * Atualiza os dados de um dispositivo existente no banco de dados.
     *
     * @param device Objeto Device contendo os dados atualizados do dispositivo.
     */
    @Override
    public void updateDevice(Device device) {
        String sql = "UPDATE Device SET name = ?, type = ?, status = ?, residence_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, device.getName());
            stmt.setString(2, device.getType());
            stmt.setDouble(3, device.getAverageConsumption());
            stmt.setLong(4, device.getResidenceId());
            stmt.setLong(5, device.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta um dispositivo pelo seu ID.
     *
     * @param id ID do dispositivo a ser deletado.
     */
    @Override
    public void deleteDevice(Long id) {
        String sql = "DELETE FROM Device WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lista todos os dispositivos cadastrados no banco de dados.
     *
     * @return Lista de objetos Device contendo todos os dispositivos.
     */
    @Override
    public List<Device> getAllDevices() {
        String sql = "SELECT * FROM Device";
        List<Device> devices = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                devices.add(new Device(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getDouble("averageConsumption"),
                        rs.getInt("residenceId")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return devices;
    }

    /**
     * Lista os dispositivos associados a uma residência específica.
     *
     * @param residenceId ID da residência para a qual os dispositivos serão buscados.
     * @return Lista de objetos Device associados à residência.
     */
    @Override
    public List<Device> getDevicesByResidenceId(Long residenceId) {
        String sql = "SELECT * FROM Device WHERE residence_id = ?";
        List<Device> devices = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, residenceId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                devices.add(new Device(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getDouble("averageConsumption"),
                        rs.getInt("residenceId")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return devices;
    }
}
