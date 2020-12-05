package bsu.tp.financial.dao;

import bsu.tp.financial.entity.Admin;

public interface AdminDAO {
    public Admin findAdminByEmail(String email);
    public void updatePassword(int id, char[] password);
    public void create(Admin admin);
    public void delete(Admin admin);
}
