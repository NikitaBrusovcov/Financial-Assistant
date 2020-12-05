package bsu.tp.financial;

import bsu.tp.financial.dao.DAOFactory;
import bsu.tp.financial.dao.UserDAO;
import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.service.impl.SecurityServiceImpl;

public class runner {
    public static void main(String[] args) {
//        DAOFactory daoFactory = DAOFactory.getInstance();
//        UserDAO userDAO = daoFactory.getUserDAO();
//        User user = userDAO.findUserById(1);
//        System.out.println(user.getId());
//        System.out.println(user.getEmail());
//        System.out.println(user.getName());
//        System.out.println(user.getSurname());
//        System.out.println(user.getPassword());
//        //System.out.println(user.getBankAccountList().size());
//        if(user.getBankAccountList().size() > 0){
//            for (BankAccount bankAccount : user.getBankAccountList()){
//                System.out.println(bankAccount.getId() + " " + bankAccount.getTitle() + " " + bankAccount.getCurrency() + " " + bankAccount.getAmountOfMoney());
//            }
//        }
        String password = "111";
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        char[] parol = securityService.createPassword(password);
        System.out.println(parol);

    }
}
