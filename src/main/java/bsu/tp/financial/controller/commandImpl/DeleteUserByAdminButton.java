package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.Admin;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.CommandException;
import bsu.tp.financial.service.*;
import bsu.tp.financial.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class DeleteUserByAdminButton implements Command {

    private final Logger logger = LoggerFactory.getLogger(DeleteUserByAdminButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        int id = Integer.parseInt(HttpUtils.checkRequestParameter(req, "id"));
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        User user;
        try {
            user = userService.findUserById(id);
            userService.deleteUser(user);
        } catch (RuntimeException exception){
            throw new CommandException("DeleteUserByAdminButton failed ", exception);
        }
        logger.info("User " + user.getEmail() + "was deleted by " + admin.getEmail());
        return CommandName.ADMIN_USERS_BUTTON;
    }
}
