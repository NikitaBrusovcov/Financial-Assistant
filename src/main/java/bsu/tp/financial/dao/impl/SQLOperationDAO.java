package bsu.tp.financial.dao.impl;

import bsu.tp.financial.connection.ConnectionDB;
import bsu.tp.financial.dao.OperationDAO;
import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.Operation;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SQLOperationDAO implements OperationDAO {

    private static final String FIND_OPERATION_BY_ID = "SELECT * FROM operation WHERE bankAccount_id = ? ORDER BY dateTime DESC";
    private static final String CREATE_OPERATION = "INSERT INTO operation (description, dateTime, type, money, bankAccount_id) VALUES(?, ?, ?, ?, ?)";

    @Override
    public void createOperation(Operation operation, BankAccount bankAccount) {
        Connection connection = ConnectionDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_OPERATION);
            preparedStatement.setString(1, operation.getDescription());
            Timestamp timestamp = Timestamp.valueOf(operation.getDateTime());
            preparedStatement.setTimestamp(2, timestamp);
            preparedStatement.setString(3, operation.getType());
            preparedStatement.setBigDecimal(4, operation.getMoney());
            preparedStatement.setInt(5, bankAccount.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //Connector.releaseConnection(connection);
        }
    }

    @Override
    public List<Operation> findOperationsByBankAccountId(int bankAccountId) {
        Connection connection = ConnectionDB.getConnection();
        List<Operation> operations = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_OPERATION_BY_ID);
            preparedStatement.setInt(1, bankAccountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Operation operation = setOperation(resultSet);
                operations.add(operation);
            }
            return operations;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            //Connector.releaseConnection(connection);
        }
    }

    private Operation setOperation(ResultSet resultSet) throws SQLException {

        Operation operation = new Operation();
        operation.setId(resultSet.getInt("id"));
        operation.setDescription(resultSet.getString("description"));
        Timestamp timestamp = resultSet.getTimestamp("dateTime");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        operation.setDateTime(timestamp.toLocalDateTime());
        operation.setMoney(resultSet.getBigDecimal("money"));
        operation.setType(resultSet.getString("type"));
        return operation;
    }

    private java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

}
