package bsu.tp.financial.service.impl;

import bsu.tp.financial.dao.AdminDAO;
import bsu.tp.financial.dao.DAOFactory;
import bsu.tp.financial.entity.Admin;
import bsu.tp.financial.exception.DAOException;
import bsu.tp.financial.service.AdminService;
import com.google.protobuf.ServiceException;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    DAOFactory daoFactory = DAOFactory.getInstance();
    AdminDAO adminDAO = daoFactory.getAdminDAO();


    @Override
    public Admin signIn(String email) throws ServiceException {
        try {
            return adminDAO.findAdminByEmail(email);
        } catch (DAOException daoException) {
            throw new ServiceException("AdminService failed", daoException);
        }
    }

    @Override
    public List<Admin> findAllAdmins() throws ServiceException {
        try {
            return adminDAO.findAllAdmins();
        } catch (DAOException daoException) {
            throw new ServiceException("AdminService failed", daoException);
        }
    }

    @Override
    public void signUp(Admin admin) throws ServiceException {
        try {
            adminDAO.createAdmin(admin);
        } catch (DAOException daoException) {
            throw new ServiceException("AdminService failed", daoException);
        }
    }

    @Override
    public Admin findAdminByEmail(String email) throws ServiceException {
        try {
            return adminDAO.findAdminByEmail(email);
        } catch (DAOException daoException) {
            throw new ServiceException("AdminService failed", daoException);
        }
    }

    @Override
    public void updatePassword(Admin admin) throws ServiceException {
        try {
            adminDAO.updatePassword(admin);
        } catch (DAOException daoException) {
            throw new ServiceException("AdminService failed", daoException);
        }
    }

    @Override
    public void deleteAdmin(Admin admin) throws ServiceException {
        try {
            adminDAO.deleteAdmin(admin);
        } catch (DAOException daoException) {
            throw new ServiceException("AdminService failed", daoException);
        }
    }
}
