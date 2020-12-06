package bsu.tp.financial.dao;

import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.DAOException;

import java.util.List;

public interface UserDAO {
    public User findUserById(int id) throws DAOException;
    public User findUserByEmail(String email) throws DAOException;
    public User createUser(User user) throws DAOException;
    public void updateUser(User user) throws DAOException;
    public void deleteUser(User user) throws DAOException;
    public List<User> findAllUsers() throws DAOException;
}
