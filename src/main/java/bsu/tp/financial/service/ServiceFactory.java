package bsu.tp.financial.service;

import bsu.tp.financial.service.impl.*;

public class ServiceFactory {

    private ServiceFactory(){

    }

    private static final ServiceFactory instance = new ServiceFactory();

    private final UserService userServiceImpl = new UserServiceImpl();
    private final BankAccountService bankAccountServiceImpl = new BankAccountServiceImpl();
    private final AdminService adminServiceImpl = new AdminServiceImpl();
    private final SecurityService securityServiceImpl = new SecurityServiceImpl();
    private final OperationService operationServiceImpl = new OperationServiceImpl();

    public static ServiceFactory getInstance(){
        return instance;
    }

    public UserService getUserService(){
        return userServiceImpl;
    }
    public BankAccountService getBankAccountService(){
        return bankAccountServiceImpl;
    }
    public AdminService getAdminService(){
        return adminServiceImpl;
    }
    public SecurityService getSecurityService(){
        return securityServiceImpl;
    }
    public OperationService getOperationService() {
        return operationServiceImpl;
    }
}
