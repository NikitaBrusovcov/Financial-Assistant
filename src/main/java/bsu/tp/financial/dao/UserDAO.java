package bsu.tp.financial.dao;

import bsu.tp.financial.entity.User;

import java.util.List;

public interface UserDAO {
    public User findUserById(int id);
    public User findUserByEmail(String email);
    public User createUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public List<User> findAllUsers();
}
