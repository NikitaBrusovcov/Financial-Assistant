package bsu.tp.financial.service;

import bsu.tp.financial.entity.Admin;
import com.google.protobuf.ServiceException;

import java.util.List;

public interface AdminService {
    public Admin signIn(String email) throws ServiceException;
    public List<Admin> findAllAdmins() throws ServiceException;
    public void signUp(Admin admin) throws ServiceException;
    public Admin findAdminByEmail(String email) throws ServiceException;
    public void updatePassword(Admin admin) throws ServiceException;
    public void deleteAdmin(Admin admin) throws ServiceException;
}
