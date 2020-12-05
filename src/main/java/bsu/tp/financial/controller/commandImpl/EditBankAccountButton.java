package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.Currency;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.CommandException;
import bsu.tp.financial.service.*;
import bsu.tp.financial.util.BankAccountUtils;
import bsu.tp.financial.util.HttpUtils;
import com.google.protobuf.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class EditBankAccountButton implements Command {

    private final Logger logger = LoggerFactory.getLogger(EditBankAccountButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    BankAccountService bankAccountService = serviceFactory.getBankAccountService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {

        String action = HttpUtils.checkRequestParameter(req, "actionBankAccount");
        User user = (User) req.getSession().getAttribute("user");

        if (action.equals("add")){
            BankAccount bankAccount = createBankAccount(req);
            try {
                bankAccountService.createBankAccount(bankAccount, user);
            } catch (ServiceException exception){
                throw new CommandException("EditBankAccountButton failed ", exception);
            }
            logger.info(user.getEmail() + " create bankAccount " + bankAccount.getTitle() + " (id = " + bankAccount.getId() + ")");
        }

        if(action.equals("delete")){
            int id = Integer.parseInt(HttpUtils.checkRequestParameter(req, "id"));
            BankAccount bankAccount = BankAccountUtils.findBankAccountFromUser(id, user);
            try {
                bankAccountService.deleteBankAccount(bankAccount);
            } catch (ServiceException exception){
                throw new CommandException("EditBankAccountButton failed ", exception);
            }
            logger.info(user.getEmail() + " delete bankAccount " + bankAccount.getTitle() + " (id = " + bankAccount.getId() + ")");
        }

        if(action.equals("edit")){
            int id = Integer.parseInt(HttpUtils.checkRequestParameter(req, "id"));
            String title = HttpUtils.checkRequestParameter(req, "title");
            BankAccount bankAccount = BankAccountUtils.findBankAccountFromUser(id, user);
            String oldTitle = bankAccount.getTitle();
            bankAccount.setTitle(title);
            try {
                bankAccountService.updateBankAccount(bankAccount);
            } catch (ServiceException exception){
                throw new CommandException("EditBankAccountButton failed ", exception);
            }
            logger.info(user.getEmail() + " edit bankAccount " + bankAccount.getTitle() + " (id = " + bankAccount.getId() + "), old title = " + oldTitle);
        }

        return CommandName.BANK_ACCOUNTS_BUTTON;
    }


    private BankAccount createBankAccount(HttpServletRequest req){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setTitle(HttpUtils.checkRequestParameter(req, "title"));
        bankAccount.setCurrency(Currency.valueOf(HttpUtils.checkRequestParameter(req, "currency")));
        bankAccount.setAmountOfMoney(BigDecimal.valueOf(0));
        return bankAccount;
    }
}
