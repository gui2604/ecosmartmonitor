package br.com.fiap.ecosmartmonitor.factory;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.ecosmartmonitor.dao.*;
import br.com.fiap.ecosmartmonitor.util.ConnectionDB;

/**
 * Fábrica para criação de objetos DAO (Data Access Object).
 * Implementa o padrão Singleton para gerenciar uma única instância da fábrica e conexão com o banco de dados.
 * Oferece métodos estáticos para obter instâncias de DAOs específicos.
 * 
 * @singleton Gerencia a conexão única com o banco de dados.
 * 
 * @authors 
 *     Guilherme Barreto Santos (RM: 97674),
 *     Nicolas Oliveira da Silva (RM: 98939)
 */
public class DAOFactory {
    private static DAOFactory instance; // Singleton para a fábrica de DAOs
    private static Connection connection;

    /**
     * Construtor privado para implementação do padrão Singleton.
     * Inicializa a conexão com o banco de dados.
     *
     * @throws SQLException Caso ocorra um erro ao inicializar a conexão.
     */
    private DAOFactory() throws SQLException {
        initializeConnection();
    }

    /**
     * Retorna a instância única da DAOFactory.
     *
     * @return Instância única da DAOFactory.
     * @throws SQLException Caso ocorra um erro ao obter a conexão.
     */
    public static DAOFactory getInstance() throws SQLException {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    /**
     * Inicializa ou reinicializa a conexão com o banco de dados.
     *
     * @throws SQLException Caso ocorra um erro ao criar a conexão.
     */
    private static void initializeConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = ConnectionDB.getInstance().getConnection();
        }
    }

    /**
     * Retorna a conexão ativa com o banco de dados, garantindo que ela está inicializada.
     *
     * @return Conexão ativa com o banco de dados.
     * @throws SQLException Caso ocorra um erro ao obter a conexão.
     */
    private static Connection getConnection() throws SQLException {
        initializeConnection();
        return connection;
    }

    /**
     * Retorna uma instância de ClientDAO.
     *
     * @return Instância de ClientDAOImpl.
     * @throws SQLException Caso ocorra um erro ao criar o DAO.
     */
    public static ClientDAO getClientDAO() throws SQLException {
        return new ClientDAOImpl(getConnection());
    }

    /**
     * Retorna uma instância de ResidenceDAO.
     *
     * @return Instância de ResidenceDAOImpl.
     * @throws SQLException Caso ocorra um erro ao criar o DAO.
     */
    public static ResidenceDAO getResidenceDAO() throws SQLException {
        return new ResidenceDAOImpl(getConnection());
    }

    /**
     * Retorna uma instância de DeviceDAO.
     *
     * @return Instância de DeviceDAOImpl.
     * @throws SQLException Caso ocorra um erro ao criar o DAO.
     */
    public static DeviceDAO getDeviceDAO() throws SQLException {
        return new DeviceDAOImpl(getConnection());
    }

    /**
     * Retorna uma instância de NotificationDAO.
     *
     * @return Instância de NotificationDAOImpl.
     * @throws SQLException Caso ocorra um erro ao criar o DAO.
     */
    public static NotificationDAO getNotificationDAO() throws SQLException {
        return new NotificationDAOImpl(getConnection());
    }

    /**
     * Retorna uma instância de ConsumptionDAO.
     *
     * @return Instância de ConsumptionDAOImpl.
     * @throws SQLException Caso ocorra um erro ao criar o DAO.
     */
    public static ConsumptionDAO getConsumptionDAO() throws SQLException {
        return new ConsumptionDAOImpl(getConnection());
    }
}
