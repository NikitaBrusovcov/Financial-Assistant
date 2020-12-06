package bsu.tp.financial.dao.impl;

import bsu.tp.financial.connection.ConnectionDB;
import bsu.tp.financial.connectionPool.Connector;
import bsu.tp.financial.dao.BankAccountDAO;
import bsu.tp.financial.dao.DAOFactory;
import bsu.tp.financial.dao.OperationDAO;
import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.Currency;
import bsu.tp.financial.entity.Operation;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLBankAccountDAO implements BankAccountDAO {


    //DAOFactory daoFactory = DAOFactory.getInstance();
    //OperationDAO operationDAO = daoFactory.getOperationImpl();
    //OperationDAO operationDAO = new SQLOperationDAO();

//    ServiceFactory serviceFactory = ServiceFactory.getInstance();
//    OperationService operationService = serviceFactory.getOperationService();

    private static final String FIND_BANK_ACCOUNTS_BY_USER_ID = "SELECT bankAccount_id as id, bankaccount.title as title, bankaccount.currency as currency, bankaccount.amountOfMoney as amountOfMoney FROM userbankaccount INNER JOIN bankaccount ON userbankaccount.user_id = ? && userbankaccount.bankAccount_id = bankAccount.id";
    private static final String CREATE_BANK_ACCOUNT = "INSERT INTO bankaccount (title, currency, amountOfMoney) VALUES(?, ?, ?)";
    private static final String CREATE_USER_BANK_ACCOUNT_RELATIONSHIP = "INSERT INTO userbankaccount (user_id, bankAccount_id) VALUES (?, ?)";
    private static final String UPDATE_BANK_ACCOUNT = "UPDATE bankaccount SET title = ?, currency = ?, amountOfMoney = ?  WHERE id = ?";
    private static final String DELETE_BANK_ACCOUNT = "DELETE FROM bankaccount WHERE id = ?";
    private static final String FIND_BANK_ACCOUNT = "SELECT * FROM bankaccount WHERE id = ?";


    @Override
    public List<BankAccount> findBankAccountsByUserId(int userId) throws DAOException {
        List<BankAccount> userBankAccounts = new ArrayList<>();
        Connection connection = Connector.getConnection();
        //Connection connection = ConnectionDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BANK_ACCOUNTS_BY_USER_ID);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BankAccount bankAccount = setBankAccount(resultSet);
                userBankAccounts.add(bankAccount);
            }
        } catch (SQLException exception) {
            throw new DAOException("Failed findBankAccountsByUserId", exception);
        } finally {
            Connector.releaseConnection(connection);
        }
        return userBankAccounts;
    }

    @Override
    public void createBankAccount(BankAccount bankAccount, User user) throws DAOException {
        //Connection connection = ConnectionDB.getConnection();
        Connection connection = Connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_BANK_ACCOUNT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, bankAccount.getTitle());
            preparedStatement.setString(2, bankAccount.getCurrency().toString());
            preparedStatement.setBigDecimal(3, bankAccount.getAmountOfMoney());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            int bankAccountId = 0;
            if (resultSet.next()){
                 bankAccountId = resultSet.getInt(1);
            }
            createUserBankAccountRelationship(bankAccountId, user.getId());
        } catch (SQLException exception) {
            throw new DAOException("Failed createBankAccount", exception);
        } finally {
            Connector.releaseConnection(connection);
        }
    }

    @Override
    public void createUserBankAccountRelationship(int bankAccountId, int userId) throws DAOException {
        //Connection connection = ConnectionDB.getConnection();
        Connection connection = Connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_BANK_ACCOUNT_RELATIONSHIP);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, bankAccountId);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new DAOException("Failed createUserBankAccountRelationship", exception);
        } finally {
            Connector.releaseConnection(connection);
        }
    }

    @Override
    public void updateBankAccount(BankAccount bankAccount) throws DAOException {
        //Connection connection = ConnectionDB.getConnection();
        Connection connection = Connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BANK_ACCOUNT);
            preparedStatement.setString(1, bankAccount.getTitle());
            preparedStatement.setString(2, bankAccount.getCurrency().toString());
            preparedStatement.setBigDecimal(3, bankAccount.getAmountOfMoney());
            preparedStatement.setInt(4, bankAccount.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new DAOException("Failed updateBankAccount", exception);
        } finally {
            Connector.releaseConnection(connection);
        }
    }

    @Override
    public void deleteBankAccount(BankAccount bankAccount) throws DAOException {
        //Connection connection = ConnectionDB.getConnection();
        Connection connection = Connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BANK_ACCOUNT);
            preparedStatement.setInt(1, bankAccount.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new DAOException("Failed deleteBankAccount", exception);
        } finally {
            Connector.releaseConnection(connection);
        }
    }

    @Override
    public BankAccount findBankAccountById(int id) throws DAOException {
        //Connection connection = ConnectionDB.getConnection();
        Connection connection = Connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BANK_ACCOUNT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return setBankAccount(resultSet);
            }
            return null;
        } catch (SQLException exception) {
            throw new DAOException("Failed findBankAccountById", exception);
        } finally {
            Connector.releaseConnection(connection);
        }
    }

    private BankAccount setBankAccount(ResultSet resultSet) throws DAOException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        OperationDAO operationDAO = daoFactory.getOperationImpl();

        BankAccount bankAccount;
        try {
            bankAccount = new BankAccount();
            bankAccount.setId(resultSet.getInt("id"));
            bankAccount.setTitle(resultSet.getString("title"));
            bankAccount.setCurrency(Currency.valueOf(resultSet.getString("currency")));
            bankAccount.setAmountOfMoney(resultSet.getBigDecimal("amountOfMoney"));
            bankAccount.setOperations(operationDAO.findOperationsByBankAccountId(bankAccount.getId()));
        } catch (SQLException exception){
            throw new DAOException("SetBankAccount failed", exception);
        }
        return bankAccount;
    }

}
