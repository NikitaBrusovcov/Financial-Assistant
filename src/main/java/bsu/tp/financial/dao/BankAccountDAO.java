package bsu.tp.financial.dao;

import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.User;

import java.util.List;

public interface BankAccountDAO {
    public List<BankAccount> findBankAccountsByUserId(int userId);
    public void createBankAccount(BankAccount bankAccount, User user);
    public void updateBankAccount(BankAccount bankAccount);
    public void deleteBankAccount(BankAccount bankAccount);
    public void createUserBankAccountRelationship(int bankAccountId, int userId);
    public BankAccount findBankAccountById(int id);
}
