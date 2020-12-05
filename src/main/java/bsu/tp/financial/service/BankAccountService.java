package bsu.tp.financial.service;

import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.User;
import com.google.protobuf.ServiceException;

public interface BankAccountService {
    public void createBankAccount(BankAccount bankAccount, User user) throws ServiceException;
    public void updateBankAccount(BankAccount bankAccount) throws ServiceException;
    public void deleteBankAccount(BankAccount bankAccount) throws ServiceException;
    public void createUserBankAccountRelationship(int bankAccountId, int userId) throws ServiceException;
    public BankAccount findBankAccountById(int id) throws ServiceException;
}
