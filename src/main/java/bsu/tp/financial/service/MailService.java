package bsu.tp.financial.service;

import bsu.tp.financial.entity.BankAccount;

public interface MailService {
    public void sendMail(String emailSubject, String emailText, String email);

    //void sendMail(String emailSubject, String email, BankAccount bankAccount);
}
