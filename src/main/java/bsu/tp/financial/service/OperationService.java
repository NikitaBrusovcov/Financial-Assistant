package bsu.tp.financial.service;

import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.Operation;
import bsu.tp.financial.exception.ServiceException;

import java.util.List;

public interface OperationService {
    public void createOperation(Operation operation, BankAccount bankAccount) throws ServiceException;
    public List<Operation> findOperationsByBankAccountId(int bankAccountId) throws ServiceException;
}
