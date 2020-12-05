package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.service.*;
import bsu.tp.financial.util.HttpUtils;

import javax.servlet.http.HttpServletRequest;

public class UnitBankAccountsButton implements Command {

    //private final Logger logger = LoggerFactory.getLogger(SignUpButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();
    BankAccountService bankAccountService = serviceFactory.getBankAccountService();
    SecurityService securityService = serviceFactory.getSecurityService();
    OperationService operationService = serviceFactory.getOperationService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        String email = HttpUtils.checkRequestParameter(req, "accountMail");
        int bankAccountId = Integer.parseInt(HttpUtils.checkRequestParameter(req, "bankAccount"));
        User user = userService.findUserByEmail(email);
        bankAccountService.createUserBankAccountRelationship(bankAccountId, user.getId());
        return CommandName.BANK_ACCOUNTS_BUTTON;
    }
}
