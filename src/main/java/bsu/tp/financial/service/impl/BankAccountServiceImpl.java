package bsu.tp.financial.service.impl;

import bsu.tp.financial.dao.BankAccountDAO;
import bsu.tp.financial.dao.DAOFactory;
import bsu.tp.financial.dao.UserDAO;
import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.service.BankAccountService;

public class BankAccountServiceImpl implements BankAccountService {

    DAOFactory daoFactory = DAOFactory.getInstance();
    BankAccountDAO bankAccountDAO = daoFactory.getBankAccountDAO();
    //UserDAO userDAO = daoFactory.getUserDAO();

    @Override
    public void createBankAccount(BankAccount bankAccount, User user) {
        bankAccountDAO.createBankAccount(bankAccount, user);
//        try {
//            userDAO.createUserWithExamMark(user);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }

    @Override
    public void updateBankAccount(BankAccount bankAccount) {
        bankAccountDAO.updateBankAccount(bankAccount);
//        try {
//            userDAO.createUserWithExamMark(user);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }

    @Override
    public void deleteBankAccount(BankAccount bankAccount) {
        bankAccountDAO.deleteBankAccount(bankAccount);
//        try {
//            userDAO.createUserWithExamMark(user);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }

    @Override
    public void createUserBankAccountRelationship(int bankAccountId, int userId){
        bankAccountDAO.createUserBankAccountRelationship(bankAccountId, userId);
//        try {
//            userDAO.createUserWithExamMark(user);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }
}
