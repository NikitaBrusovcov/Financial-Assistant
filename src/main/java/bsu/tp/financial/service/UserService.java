package bsu.tp.financial.service;

import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.ServiceException;

import java.util.List;

public interface UserService {
    public User signIn(String email) throws ServiceException;
    public User signUp(User user) throws ServiceException;
    public User findUserById(int id) throws ServiceException;
    public void updateUser(User user) throws ServiceException;
    public void deleteUser(User user) throws ServiceException;
    public List<User> findAllUsers() throws ServiceException;
    public User findUserByEmail(String email) throws ServiceException;
}
