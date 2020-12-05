package bsu.tp.financial.service.impl;

import bsu.tp.financial.dao.BankAccountDAO;
import bsu.tp.financial.dao.DAOFactory;
import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.DAOException;
import bsu.tp.financial.exception.ServiceException;
import bsu.tp.financial.service.BankAccountService;

public class BankAccountServiceImpl implements BankAccountService {

    DAOFactory daoFactory = DAOFactory.getInstance();
    BankAccountDAO bankAccountDAO = daoFactory.getBankAccountDAO();

    @Override
    public void createBankAccount(BankAccount bankAccount, User user) throws ServiceException {
        try {
            bankAccountDAO.createBankAccount(bankAccount, user);
        } catch (DAOException daoException) {
            throw new ServiceException("BankAccountService failed", daoException);
        }
    }

    @Override
    public void updateBankAccount(BankAccount bankAccount) throws ServiceException {
        try {
            bankAccountDAO.updateBankAccount(bankAccount);
        } catch (DAOException daoException) {
            throw new ServiceException("BankAccountService failed", daoException);
        }
    }

    @Override
    public void deleteBankAccount(BankAccount bankAccount) throws ServiceException {
        try {
            bankAccountDAO.deleteBankAccount(bankAccount);
        } catch (DAOException daoException) {
            throw new ServiceException("BankAccountService failed", daoException);
        }
    }

    @Override
    public void createUserBankAccountRelationship(int bankAccountId, int userId) throws ServiceException {
        try {
            bankAccountDAO.createUserBankAccountRelationship(bankAccountId, userId);
        } catch (DAOException daoException) {
            throw new ServiceException("BankAccountService failed", daoException);
        }
    }

    @Override
    public BankAccount findBankAccountById(int id) throws ServiceException {
        try {
            return bankAccountDAO.findBankAccountById(id);
        } catch (DAOException daoException) {
            throw new ServiceException("BankAccountService failed", daoException);
        }
    }
}
