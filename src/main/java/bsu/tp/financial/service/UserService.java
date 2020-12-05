package bsu.tp.financial.service;

import bsu.tp.financial.entity.User;

import java.util.List;

public interface UserService {
    public User signIn(String email);
    public User signUp(User user);
    public User findUserById(int id);
    public void updateUser(User user);
    public void deleteUser(User user);
    public List<User> findAllUsers();
    public User findUserByEmail(String email);
}
