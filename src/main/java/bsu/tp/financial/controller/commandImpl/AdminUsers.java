package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.CommandException;
import bsu.tp.financial.service.BankAccountService;
import bsu.tp.financial.service.SecurityService;
import bsu.tp.financial.service.ServiceFactory;
import bsu.tp.financial.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class AdminUsers implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        List<User> users;
        try {
            users = userService.findAllUsers();
        } catch (RuntimeException exception){
            throw new CommandException("AdminUsers failed ", exception);
        }
        req.setAttribute("users", users);
        return CommandName.ADMIN_USERS;
    }
}
