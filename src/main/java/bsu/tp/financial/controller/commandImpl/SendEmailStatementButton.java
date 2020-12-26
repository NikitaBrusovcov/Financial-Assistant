package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.Operation;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.CommandException;
import bsu.tp.financial.service.*;
import bsu.tp.financial.util.HttpUtils;
import com.google.protobuf.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
            String text = createStatement(bankAccount);
            mailService.sendMail("Bank account statement", text, user.getEmail());
        } catch (ServiceException exception){
            throw new CommandException("SendEmailStatementButton failed",  exception);
        }

        logger.info(bankAccount.getTitle() + " statement was sent on " + user.getEmail());
        return CommandName.BANK_ACCOUNTS_BUTTON;
    }

    private String createStatement(BankAccount bankAccount) {
        List<Operation> operations = bankAccount.getOperations();
        StringBuilder statement = new StringBuilder();
        statement.append("Statement of ").append(bankAccount.getTitle()).append("<br><br>");
        for (Operation operation : operations) {
            statement.append(operation.toString()).append("<br>");
        }
        return statement.toString();
    }
}
