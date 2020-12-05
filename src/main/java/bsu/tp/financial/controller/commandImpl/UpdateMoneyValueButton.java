package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.Operation;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.CommandException;
import bsu.tp.financial.service.*;
import bsu.tp.financial.util.BankAccountUtils;
import bsu.tp.financial.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class UpdateMoneyValueButton implements Command {

    private final Logger logger = LoggerFactory.getLogger(UpdateMoneyValueButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();
    BankAccountService bankAccountService = serviceFactory.getBankAccountService();
    SecurityService securityService = serviceFactory.getSecurityService();
    OperationService operationService = serviceFactory.getOperationService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        if (HttpUtils.isMethodGet(req)) {
            logger.info("Failed, call method get in UpdateMoneyValueButton.");
            throw new CommandException("UpdateMoneyValueButton failed ", new RuntimeException());
        }

        int id = Integer.parseInt(HttpUtils.checkRequestParameter(req, "id"));
        User user = (User) req.getSession().getAttribute("user");
        BankAccount editBankAccount = BankAccountUtils.findBankAccountFromUser(id, user);

        if (editBankAccount != null){
            editBankAccount.setAmountOfMoney(updatedMoneyValue(editBankAccount.getAmountOfMoney(), req));
        } else {
            throw new CommandException("UpdateMoneyValueButton failed ", new RuntimeException());
        }
        Operation operation = createNewOperation(req);

        try {
            operationService.createOperation(operation, editBankAccount);
            bankAccountService.updateBankAccount(editBankAccount);
        } catch (RuntimeException exception) {
            throw new CommandException("UpdateMoneyValueButton failed ", exception);
        }

        logger.info(editBankAccount.getTitle() + "(" + editBankAccount.getId() + ") have new operation: " + operation + " \nUpdated money value " + editBankAccount.getAmountOfMoney());

        if(req.getParameter("rainyDay") != null && req.getParameter("rainyDay").equals("true")){
            return CommandName.RAINY_DAY;
        }

        return CommandName.BANK_ACCOUNTS_BUTTON;
    }


    private BigDecimal updatedMoneyValue(BigDecimal bankAccountValue, HttpServletRequest req){
        String action = HttpUtils.checkRequestParameter(req, "action");
        BigDecimal changeValue = BigDecimal.valueOf(Double.parseDouble(HttpUtils.checkRequestParameter(req, "money")));
        if (action.equals("add")){
            return bankAccountValue.add(changeValue);
        }
        if (action.equals("delete")){
            if (bankAccountValue.compareTo(changeValue) > 0){
                return bankAccountValue.subtract(changeValue);
            }
        }
        return bankAccountValue;
    }

    private Operation createNewOperation(HttpServletRequest req){
        Operation operation = new Operation();
        operation.setDescription(HttpUtils.checkRequestParameter(req, "description"));
        operation.setType(HttpUtils.checkRequestParameter(req, "action"));
        operation.setMoney(BigDecimal.valueOf(Double.parseDouble(HttpUtils.checkRequestParameter(req, "money"))));
        operation.setDateTime(LocalDateTime.now());
        return operation;
    }
}
