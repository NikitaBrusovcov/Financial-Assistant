package bsu.tp.financial.dao;

import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.Operation;
import bsu.tp.financial.exception.DAOException;

import java.util.List;

public interface OperationDAO {
    public void createOperation(Operation operation, BankAccount bankAccount) throws DAOException;
    public List<Operation> findOperationsByBankAccountId(int bankAccountId) throws DAOException;
}
