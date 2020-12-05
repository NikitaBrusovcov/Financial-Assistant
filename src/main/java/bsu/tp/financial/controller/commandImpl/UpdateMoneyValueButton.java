package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.Operation;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.service.*;
import bsu.tp.financial.util.BankAccountUtils;
import bsu.tp.financial.util.HttpUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class UpdateMoneyValueButton implements Command {

    //private final Logger logger = LoggerFactory.getLogger(SignUpButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();
    BankAccountService bankAccountService = serviceFactory.getBankAccountService();
    SecurityService securityService = serviceFactory.getSecurityService();
    OperationService operationService = serviceFactory.getOperationService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        if (HttpUtils.isMethodGet(req)) {
            //logger.info("Failed, call method get in signUp page.");
            //return CommandName.ERROR.getCommand().callCommandMethod(req);
        }

        String action = req.getParameter("action");
        int id = Integer.parseInt(req.getParameter("id"));
        BigDecimal money = BigDecimal.valueOf(Double.parseDouble(req.getParameter("money")));
        String description = req.getParameter("description");
        User user = (User) req.getSession().getAttribute("user");

        BankAccount editBankAccount = BankAccountUtils.findBankAccountFromUser(id, user);
        editBankAccount.setAmountOfMoney(updatedMoneyValue(action, editBankAccount.getAmountOfMoney(), money));

        Operation operation = createNewOperation(description, action, money);
        //LocalDateTime now = LocalDateTime.now();

        try {
            operationService.createOperation(operation, editBankAccount);
            bankAccountService.updateBankAccount(editBankAccount);

        } catch (RuntimeException exception) {
            //throw new CommandException("Update money value failed ", exception);
        }
        //logger.info(editBankAccount.getTitle() + " updated money value " + editBankAccount.getAmountOfMoney());

        if(req.getParameter("rainyDay") != null && req.getParameter("rainyDay").equals("true")){
            return CommandName.RAINY_DAY;
        }
        return CommandName.BANK_ACCOUNTS_BUTTON;
    }

    private BankAccount findBankAccount(int id, User user){
        for (BankAccount bankAccount : user.getBankAccountList()){
            if (bankAccount.getId() == id){
                return bankAccount;
            }
        }
        return null;
    }

    private BigDecimal updatedMoneyValue(String action, BigDecimal bankAccountValue, BigDecimal changeValue){
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

    private Operation createNewOperation(String description, String type, BigDecimal money){
        Operation operation = new Operation();
        operation.setDescription(description);
        operation.setType(type);
        operation.setMoney(money);
        operation.setDateTime(LocalDateTime.now());
        return operation;
    }
}
