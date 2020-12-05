package bsu.tp.financial.service.impl;

import bsu.tp.financial.dao.DAOFactory;
import bsu.tp.financial.dao.UserDAO;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.DAOException;
import bsu.tp.financial.exception.ServiceException;
import bsu.tp.financial.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    DAOFactory daoFactory = DAOFactory.getInstance();
    UserDAO userDAO = daoFactory.getUserDAO();

    @Override
    public User signIn(String email) throws ServiceException {
        try {
            return userDAO.findUserByEmail(email);
        } catch (DAOException daoException) {
            throw new ServiceException("UserService failed", daoException);
        }
    }

    @Override
    public User signUp(User user) throws ServiceException {
        try {
            return userDAO.createUser(user);
        } catch (DAOException daoException) {
            throw new ServiceException("UserService failed", daoException);
        }
    }

    @Override
    public User findUserById(int id) throws ServiceException {
        try {
            return userDAO.findUserById(id);
        } catch (DAOException daoException) {
            throw new ServiceException("UserService failed", daoException);
        }
    }

    @Override
    public void updateUser(User user) throws ServiceException {
        try {
            userDAO.updateUser(user);
        } catch (DAOException daoException) {
            throw new ServiceException("UserService failed", daoException);
        }
    }

    @Override
    public void deleteUser(User user) throws ServiceException {
        try {
            userDAO.deleteUser(user);
        } catch (DAOException daoException) {
            throw new ServiceException("UserService failed", daoException);
        }
    }

    public List<User> findAllUsers() throws ServiceException {
        try {
            return userDAO.findAllUsers();
        } catch (DAOException daoException) {
            throw new ServiceException("UserService failed", daoException);
        }
    }

    @Override
    public User findUserByEmail(String email) throws ServiceException {
        try {
            return userDAO.findUserByEmail(email);
        } catch (DAOException daoException) {
            throw new ServiceException("UserService failed", daoException);
        }
    }
}
