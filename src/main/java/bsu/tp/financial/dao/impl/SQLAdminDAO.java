package bsu.tp.financial.dao.impl;

import bsu.tp.financial.connection.ConnectionDB;
import bsu.tp.financial.dao.AdminDAO;
import bsu.tp.financial.entity.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLAdminDAO implements AdminDAO {

    private static final String FIND_ADMIN_BY_EMAIL = "SELECT * FROM admin WHERE email = ?";

    @Override
    public Admin findAdminByEmail(String email) {
        Connection connection = ConnectionDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ADMIN_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return setAdmin(resultSet);
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
//            catch (SQLException exception) {
//            throw new DAOException("Field findByEmail", exception);
        } finally {
            //Connector.releaseConnection(connection);
        }
    }

    private Admin setAdmin(ResultSet resultSet){
        try {
            Admin admin = new Admin();
            admin.setId(resultSet.getInt("id"));
            admin.setEmail(resultSet.getString("email"));
            admin.setPassword(resultSet.getString("password").toCharArray());
            return admin;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
//            catch (SQLException exception) {
//            throw new DAOException("Field setAdmin", exception);
        }
    }

    @Override
    public void updatePassword(int id, char[] password) {

    }

    @Override
    public void create(Admin admin) {

    }

    @Override
    public void delete(Admin admin) {

    }

}
