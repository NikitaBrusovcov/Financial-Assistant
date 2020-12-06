package bsu.tp.financial.dao;

import bsu.tp.financial.entity.Admin;
import bsu.tp.financial.exception.DAOException;

import java.util.List;

public interface AdminDAO {
    public Admin findAdminByEmail(String email) throws DAOException;
    public void updatePassword(Admin admin) throws DAOException;
    public List<Admin> findAllAdmins() throws DAOException;
    public void createAdmin(Admin admin) throws DAOException;
    public void deleteAdmin(Admin admin) throws DAOException;
}
