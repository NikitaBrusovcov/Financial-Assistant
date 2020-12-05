package bsu.tp.financial.service;

import bsu.tp.financial.entity.Admin;

import java.util.List;

public interface AdminService {
    public Admin signIn(String email);
    public List<Admin> findAllAdmins();
    public void signUp(Admin admin);
    public Admin findAdminByEmail(String email);
    public void updatePassword(Admin admin);
    public void deleteAdmin(Admin admin);
}
