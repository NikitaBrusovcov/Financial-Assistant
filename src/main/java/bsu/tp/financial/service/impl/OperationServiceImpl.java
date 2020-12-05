package bsu.tp.financial.service.impl;

import bsu.tp.financial.dao.BankAccountDAO;
import bsu.tp.financial.dao.DAOFactory;
import bsu.tp.financial.dao.OperationDAO;
import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.Operation;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.DAOException;
import bsu.tp.financial.exception.ServiceException;
import bsu.tp.financial.service.OperationService;

public class OperationServiceImpl implements OperationService {

    DAOFactory daoFactory = DAOFactory.getInstance();
    OperationDAO operationDAO = daoFactory.getSqlOperationImpl();

    @Override
    public void createOperation(Operation operation, BankAccount bankAccount) throws ServiceException {
        try {
            operationDAO.createOperation(operation, bankAccount);
        } catch (DAOException daoException) {
            throw new ServiceException("OperationService failed", daoException);
        }
    }
}
