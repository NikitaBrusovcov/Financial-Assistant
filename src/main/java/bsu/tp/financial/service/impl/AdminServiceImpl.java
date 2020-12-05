package bsu.tp.financial.service.impl;

import bsu.tp.financial.dao.AdminDAO;
import bsu.tp.financial.dao.DAOFactory;
import bsu.tp.financial.entity.Admin;
import bsu.tp.financial.service.AdminService;

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
}
