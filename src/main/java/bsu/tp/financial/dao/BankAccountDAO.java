package bsu.tp.financial.dao;

import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.DAOException;

import java.util.List;

public interface BankAccountDAO {
    public List<BankAccount> findBankAccountsByUserId(int userId) throws DAOException;
    public void createBankAccount(BankAccount bankAccount, User user) throws DAOException;
    public void updateBankAccount(BankAccount bankAccount) throws DAOException;
    public void deleteBankAccount(BankAccount bankAccount) throws DAOException;
    public void createUserBankAccountRelationship(int bankAccountId, int userId) throws DAOException;
    public BankAccount findBankAccountById(int id) throws DAOException;
}
