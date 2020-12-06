package bsu.tp.financial.dao.impl;

import bsu.tp.financial.connection.ConnectionDB;
import bsu.tp.financial.dao.AdminDAO;
import bsu.tp.financial.entity.Admin;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLAdminDAO implements AdminDAO {

    private static final String FIND_ADMIN_BY_EMAIL = "SELECT * FROM admin WHERE email = ?";
    private static final String FIND_ALL_ADMIN = "SELECT * FROM admin ORDER BY email";
    private static final String CREATE_ADMIN = "INSERT INTO admin (email, password) VALUES(?, ?)";
    private static final String UPDATE_ADMIN = "UPDATE admin SET password = ?  WHERE id = ?";
    private static final String DELETE_ADMIN = "DELETE FROM admin WHERE id = ?";


    @Override
    public Admin findAdminByEmail(String email) throws DAOException{
        Connection connection = ConnectionDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ADMIN_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return setAdmin(resultSet);
            }
            return null;
        } catch (SQLException exception) {
            throw new DAOException("Failed findAdminByEmail", exception);
        } finally {
            //Connector.releaseConnection(connection);
        }
    }

    @Override
    public List<Admin> findAllAdmins() throws DAOException {
        List<Admin> admins = new ArrayList<>();
        Connection connection = ConnectionDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_ADMIN);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                admins.add(setAdmin(resultSet));
            }
            return admins;
        } catch (SQLException exception) {
            throw new DAOException("Failed findAllAdmins", exception);
        } finally {
            //Connector.releaseConnection(connection);
        }
    }

    @Override
    public void createAdmin(Admin admin) throws DAOException {
        Connection connection = ConnectionDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ADMIN);
            preparedStatement.setString(1, admin.getEmail());
            preparedStatement.setString(2, String.valueOf(admin.getPassword()));
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new DAOException("Failed createAdmin", exception);
        } finally {
            //Connector.releaseConnection(connection);
        }
    }

    @Override
    public void updatePassword(Admin admin) throws DAOException {
        Connection connection = ConnectionDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADMIN);
            preparedStatement.setString(1, String.valueOf(admin.getPassword()));
            preparedStatement.setInt(2, admin.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new DAOException("Failed updatePassword", exception);
        } finally {
            //Connector.releaseConnection(connection);
        }
    }

    @Override
    public void deleteAdmin(Admin admin) throws DAOException {
        Connection connection = ConnectionDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ADMIN);
            preparedStatement.setInt(1, admin.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new DAOException("Failed deleteAdmin", exception);
        } finally {
            //Connector.releaseConnection(connection);
        }
    }

    private Admin setAdmin(ResultSet resultSet) throws DAOException {
        Admin admin;
        try {
            admin = new Admin();
            admin.setId(resultSet.getInt("id"));
            admin.setEmail(resultSet.getString("email"));
            admin.setPassword(resultSet.getString("password").toCharArray());
            return admin;
        } catch (SQLException exception) {
            throw new DAOException("Failed setAdmin", exception);
        }
    }
}
