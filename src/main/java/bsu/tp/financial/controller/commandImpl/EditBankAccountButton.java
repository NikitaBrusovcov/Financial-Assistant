package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.Currency;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.service.*;
import bsu.tp.financial.util.BankAccountUtils;
import bsu.tp.financial.util.HttpUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class EditBankAccountButton implements Command {

    //private final Logger logger = LoggerFactory.getLogger(SignUpButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();
    BankAccountService bankAccountService = serviceFactory.getBankAccountService();
    SecurityService securityService = serviceFactory.getSecurityService();
    OperationService operationService = serviceFactory.getOperationService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {

        String action = req.getParameter("actionBankAccount");
        User user = (User) req.getSession().getAttribute("user");

        if (action.equals("add")){
            BankAccount bankAccount = createBankAccount(req);
            bankAccountService.createBankAccount(bankAccount, user);
        }

        if(action.equals("delete")){
            int id = Integer.parseInt(HttpUtils.checkRequestParameter(req, "id"));
            BankAccount bankAccount = BankAccountUtils.findBankAccountFromUser(id, user);
            bankAccountService.deleteBankAccount(bankAccount);
        }

        if(action.equals("edit")){
            int id = Integer.parseInt(HttpUtils.checkRequestParameter(req, "id"));
            String title = HttpUtils.checkRequestParameter(req, "title");
            BankAccount bankAccount = BankAccountUtils.findBankAccountFromUser(id, user);
            bankAccount.setTitle(title);
            bankAccountService.updateBankAccount(bankAccount);
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
