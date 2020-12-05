package bsu.tp.financial.service;

import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.User;

public interface BankAccountService {
    public void createBankAccount(BankAccount bankAccount, User user);
    public void updateBankAccount(BankAccount bankAccount);
    public void deleteBankAccount(BankAccount bankAccount);
    public void createUserBankAccountRelationship(int bankAccountId, int userId);
}
