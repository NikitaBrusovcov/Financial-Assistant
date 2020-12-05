package bsu.tp.financial.service.impl;

import bsu.tp.financial.dao.AdminDAO;
import bsu.tp.financial.dao.DAOFactory;
import bsu.tp.financial.entity.Admin;
import bsu.tp.financial.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    DAOFactory daoFactory = DAOFactory.getInstance();
    AdminDAO adminDAO = daoFactory.getAdminDAO();


    @Override
    public Admin signIn(String email) {
        return adminDAO.findAdminByEmail(email);
//        try {
//            return adminDAO.findByEmail(email);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }

    @Override
    public List<Admin> findAllAdmins() {
        return adminDAO.findAllAdmins();
//        try {
//            return adminDAO.findByEmail(email);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }

    @Override
    public void signUp(Admin admin) {
        adminDAO.createAdmin(admin);
//        try {
//            return adminDAO.findByEmail(email);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }

    @Override
    public Admin findAdminByEmail(String email) {
        return adminDAO.findAdminByEmail(email);
//        try {
//            return adminDAO.findByEmail(email);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }

    @Override
    public void updatePassword(Admin admin) {
        adminDAO.updatePassword(admin);
//        try {
//            return adminDAO.findByEmail(email);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }

    @Override
    public void deleteAdmin(Admin admin) {
        adminDAO.deleteAdmin(admin);
//        try {
//            return adminDAO.findByEmail(email);
//        } catch (DAOException daoException) {
//            throw new ServiceException("message", daoException);
//        }
    }
}
