package bsu.tp.financial.service;

import bsu.tp.financial.entity.BankAccount;

public interface MailService {
    public void sendMail(String email, BankAccount bankAccount);
}
