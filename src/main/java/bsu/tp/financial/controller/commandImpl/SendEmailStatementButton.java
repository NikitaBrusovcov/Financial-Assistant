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

public class SendEmailStatementButton implements Command {

    private final Logger logger = LoggerFactory.getLogger(SendEmailStatementButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    BankAccountService bankAccountService = serviceFactory.getBankAccountService();
    MailService mailService = serviceFactory.getMailService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        int id = Integer.parseInt(HttpUtils.checkRequestParameter(req, "id"));
        BankAccount bankAccount;
        try {
            bankAccount = bankAccountService.findBankAccountById(id);
            mailService.sendMail(user.getEmail(), bankAccount);
        } catch (ServiceException exception){
            throw new CommandException("SendEmailStatementButton failed",  exception);
        }

        logger.info(bankAccount.getTitle() + " statement was sent on " + user.getEmail());
        return CommandName.BANK_ACCOUNTS_BUTTON;
    }
}
