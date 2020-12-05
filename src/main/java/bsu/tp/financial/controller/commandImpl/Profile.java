package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.Currency;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.CommandException;
import bsu.tp.financial.service.ServiceFactory;
import bsu.tp.financial.service.UserService;
import bsu.tp.financial.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Profile implements Command {

    private final Logger logger = LoggerFactory.getLogger(Profile.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {

        User user = null;
        user = getUpdatedUser(req);
        req.setAttribute("currencies", Currency.values());

        switch (req.getPathInfo()) {
            case ("/personalInfo"): {
                return CommandName.PERSONAL_INFO;
            }
            case ("/bankAccounts"): {
                return CommandName.BANK_ACCOUNTS;
            }
            case ("/rainyDay"): {
                return CommandName.RAINY_DAY;
            }
            case ("/statement"): {
                int id = Integer.parseInt(HttpUtils.checkRequestParameter(req, "id"));
                if (setBankAccountInRequest(user.getBankAccountList(), id, req)) {
                    return CommandName.STATEMENT;
                } else {
                    throw new CommandException("Get statement failed, id doesn't exist ", new RuntimeException());
                }
            }
            case ("/edit"): {
                return CommandName.EDIT_PROFILE;
            }
            case ("/editBankAccount"): {
                int id = Integer.parseInt(HttpUtils.checkRequestParameter(req, "id"));
                if (setBankAccountInRequest(user.getBankAccountList(), id, req)) {
                    return CommandName.EDIT_BANK_ACCOUNT;
                } else {
                    throw new CommandException("EditBankAccount failed, id doesn't exist ", new RuntimeException());
                }
            }
            case ("/unitBankAccounts"): {
                return CommandName.UNIT_BANK_ACCOUNTS;
            }
            default: {
                return CommandName.PROFILE;
            }
        }
    }

    private User getUpdatedUser(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        try {
            user = userService.findUserById(user.getId());
        } catch (RuntimeException exception) {
            throw new CommandException("Profile failed", exception);
        }
        HttpUtils.updateSession(req, "user", user);
        return user;
    }


    private boolean setBankAccountInRequest(List<BankAccount> bankAccounts, int id, HttpServletRequest req) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getId() == id) {
                req.setAttribute("bankAccount", bankAccount);
                return true;
            }
        }
        return false;
    }
}