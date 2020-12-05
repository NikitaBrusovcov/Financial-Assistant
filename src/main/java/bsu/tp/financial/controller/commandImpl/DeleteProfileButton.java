package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.Admin;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.CommandException;
import bsu.tp.financial.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class DeleteProfileButton implements Command {

    private final Logger logger = LoggerFactory.getLogger(DeleteProfileButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();
    AdminService adminService = serviceFactory.getAdminService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        deleteAccount(user, admin);
        req.getSession().invalidate();
        return CommandName.SIGN_OUT_BUTTON;
    }

    private void deleteAccount(User user, Admin admin){
        if (user != null){
            try {
                userService.deleteUser(user);
            } catch (RuntimeException exception){
                throw new CommandException("DeleteProfileButton failed ", exception);
            }
            logger.info(user.getEmail() + " delete account and signOut");
            return;
        }
        if (admin != null){
            try {
                adminService.deleteAdmin(admin);
            } catch (RuntimeException exception){
                throw new CommandException("DeleteProfileButton failed ", exception);
            }
            logger.info(admin.getEmail() + " delete account and signOut");
            return;
        }
    }
}
