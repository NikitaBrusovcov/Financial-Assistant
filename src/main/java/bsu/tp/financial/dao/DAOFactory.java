package bsu.tp.financial.dao;

import bsu.tp.financial.dao.impl.SQLAdminDAO;
import bsu.tp.financial.dao.impl.SQLBankAccountDAO;
import bsu.tp.financial.dao.impl.SQLOperationDAO;
import bsu.tp.financial.dao.impl.SQLUserDAO;

public class DAOFactory {

    private DAOFactory(){

    }

    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO sqlUserImpl = new SQLUserDAO();
    private final BankAccountDAO sqlBankAccountImpl = new SQLBankAccountDAO();
    private final AdminDAO sqlAdminImpl = new SQLAdminDAO();
    private final OperationDAO sqlOperationImpl = new SQLOperationDAO();

    public static DAOFactory getInstance(){
        return instance;
    }

    public UserDAO getUserDAO(){
        return sqlUserImpl;
    }
    public BankAccountDAO getBankAccountDAO(){
        return sqlBankAccountImpl;
    }
    public AdminDAO getAdminDAO(){
        return sqlAdminImpl;
    }
    public OperationDAO getOperationImpl(){
        return sqlOperationImpl;
    }
}
