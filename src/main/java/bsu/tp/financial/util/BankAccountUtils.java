package bsu.tp.financial.util;

import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.User;

public class BankAccountUtils {
    public static BankAccount findBankAccountFromUser(int id, User user){
        for (BankAccount bankAccount : user.getBankAccountList()){
            if (bankAccount.getId() == id){
                return bankAccount;
            }
        }
        return null;
    }
}
