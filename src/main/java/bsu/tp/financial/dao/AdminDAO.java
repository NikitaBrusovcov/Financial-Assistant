package bsu.tp.financial.dao;

import bsu.tp.financial.entity.Admin;

import java.util.List;

public interface AdminDAO {
    public Admin findAdminByEmail(String email);
    public void updatePassword(Admin admin);
    public List<Admin> findAllAdmins();
    public void createAdmin(Admin admin);
    public void deleteAdmin(Admin admin);
}
