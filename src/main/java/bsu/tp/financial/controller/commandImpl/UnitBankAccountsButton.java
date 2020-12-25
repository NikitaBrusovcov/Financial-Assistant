package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.CommandException;
import bsu.tp.financial.service.*;
import bsu.tp.financial.util.HttpUtils;
import com.google.protobuf.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class UnitBankAccountsButton implements Command {

    private final Logger logger = LoggerFactory.getLogger(UnitBankAccountsButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();
    BankAccountService bankAccountService = serviceFactory.getBankAccountService();
    SecurityService securityService = serviceFactory.getSecurityService();
    OperationService operationService = serviceFactory.getOperationService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        User userSession = (User) req.getSession().getAttribute("user");
        String email = HttpUtils.checkRequestParameter(req, "accountMail");
        int bankAccountId = Integer.parseInt(HttpUtils.checkRequestParameter(req, "bankAccount"));
        User user;
        try {
            user = userService.findUserByEmail(email);
            if (user == null){
                throw new CommandException("UnitBankAccountsButton failed, user does not exist", new RuntimeException());
            }
            bankAccountService.createUserBankAccountRelationship(bankAccountId, user.getId());
        } catch (ServiceException exception){
            throw new CommandException("UnitBankAccountsButton failed ", exception);
        }
        logger.info(userSession.getEmail() + "unit bankAccount with id " + bankAccountId + " with " + user.getEmail());
        return CommandName.BANK_ACCOUNTS_BUTTON;
    }
}
