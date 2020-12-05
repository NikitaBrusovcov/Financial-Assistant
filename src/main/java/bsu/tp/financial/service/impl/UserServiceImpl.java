package bsu.tp.financial.service.impl;

import bsu.tp.financial.dao.DAOFactory;
import bsu.tp.financial.dao.UserDAO;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    DAOFactory daoFactory = DAOFactory.getInstance();
    UserDAO userDAO = daoFactory.getUserDAO();

    public UserServiceImpl() {
    }

    @Override
    public User signIn(String email){
        return userDAO.findUserByEmail(email);
//        try {
//            return userDAO.findUserByEmail(email);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }

    @Override
    public User signUp(User user) {
        return userDAO.createUser(user);
//        try {
//            userDAO.createUserWithExamMark(user);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }

    @Override
    public User findUserById(int id) {
        return userDAO.findUserById(id);
//        try {
//            return userDAO.findUserById(id);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
//        try {
//            return userDAO.findUserById(id);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
//        try {
//            return userDAO.findUserById(id);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }
    public List<User> findAllUsers(){
        return userDAO.findAllUsers();
        //try {
//            return userDAO.findUserById(id);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }

    @Override
    public User findUserByEmail(String email){
        return userDAO.findUserByEmail(email);
        //try {
//            return userDAO.findUserById(id);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }
}
