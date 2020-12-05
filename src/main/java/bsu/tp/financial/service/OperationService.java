package bsu.tp.financial.service;

import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.Operation;

public interface OperationService {
    public void createOperation(Operation operation, BankAccount bankAccount);
}
