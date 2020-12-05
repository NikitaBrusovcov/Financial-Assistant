package bsu.tp.financial.dao;

import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.Operation;

import java.util.List;

public interface OperationDAO {
    public void createOperation(Operation operation, BankAccount bankAccount);
    public List<Operation> findOperationsByBankAccountId(int bankAccountId);
}
