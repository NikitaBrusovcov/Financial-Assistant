package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.service.*;
import bsu.tp.financial.util.HttpUtils;

import javax.servlet.http.HttpServletRequest;

public class DeleteUserByAdminButton implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();
    BankAccountService bankAccountService = serviceFactory.getBankAccountService();
    SecurityService securityService = serviceFactory.getSecurityService();
    OperationService operationService = serviceFactory.getOperationService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        int id = Integer.parseInt(HttpUtils.checkRequestParameter(req, "id"));
        User user = userService.findUserById(id);
        userService.deleteUser(user);
        return CommandName.ADMIN_USERS_BUTTON;
    }
}
