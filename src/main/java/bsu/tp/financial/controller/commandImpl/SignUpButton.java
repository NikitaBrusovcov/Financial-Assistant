package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.Currency;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.service.BankAccountService;
import bsu.tp.financial.service.SecurityService;
import bsu.tp.financial.service.ServiceFactory;
import bsu.tp.financial.service.UserService;
import bsu.tp.financial.util.HttpUtils;
import bsu.tp.financial.util.PasswordValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SignUpButton implements Command {
    //private final Logger logger = LoggerFactory.getLogger(SignUpButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();
    BankAccountService bankAccountService = serviceFactory.getBankAccountService();
    SecurityService securityService = serviceFactory.getSecurityService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        if (HttpUtils.isMethodGet(req)) {
            //logger.info("Failed, call method get in signUp page.");
            //return CommandName.ERROR.getCommand().callCommandMethod(req);
        }
        if(!PasswordValidator.validatePassword(req)){
            //logger.info("Failed signUp, passwords didn't match. (Email: " + req.getParameter("email") + ")");
            req.setAttribute("wrongInformation", true);
            return CommandName.SIGN_UP_BUTTON;
        }
        User user = createUser(req);
        BankAccount rainyDayBankAccount = createRainyDayBankAccount(req);
        try {
            user = userService.signUp(user);
            HttpUtils.updateSession(req, "user", user);
            bankAccountService.createBankAccount(rainyDayBankAccount, user);
        } catch (RuntimeException exception) {
            //throw new CommandException("Sign up failed ", exception);
        }
        //logger.info(user.getEmail() + " sign up");
        return CommandName.PROFILE;
    }

    private User createUser(HttpServletRequest req) {
        User user = new User();
        user.setSurname(HttpUtils.checkRequestParameter(req, "surname"));
        user.setName(HttpUtils.checkRequestParameter(req, "name"));
        user.setEmail(HttpUtils.checkRequestParameter(req, "email"));
        char[] password = securityService.createPassword(HttpUtils.checkRequestParameter(req, "password"));
        user.setPassword(password);
        return user;
    }

    private BankAccount createRainyDayBankAccount(HttpServletRequest req) {
        BankAccount rainyDayBankAccount = new BankAccount();
        rainyDayBankAccount.setTitle("rainyDay");
        rainyDayBankAccount.setCurrency(Currency.valueOf(req.getParameter("currency")));
        rainyDayBankAccount.setAmountOfMoney(BigDecimal.valueOf(0));
        return rainyDayBankAccount;
    }
}
