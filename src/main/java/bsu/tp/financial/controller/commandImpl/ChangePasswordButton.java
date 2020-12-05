package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.Admin;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.CommandException;
import bsu.tp.financial.service.*;
import bsu.tp.financial.util.HttpUtils;
import bsu.tp.financial.util.PasswordValidator;
import com.google.protobuf.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class ChangePasswordButton implements Command {

    private final Logger logger = LoggerFactory.getLogger(ChangePasswordButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();
    AdminService adminService = serviceFactory.getAdminService();
    SecurityService securityService = serviceFactory.getSecurityService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        if (HttpUtils.isMethodGet(req)) {
            logger.info("Failed, call method get in ChangePasswordButton");
            throw new CommandException("ChangePasswordButton failed", new RuntimeException());
        }

        User user = (User) req.getSession().getAttribute("user");
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        String oldPassword = HttpUtils.checkRequestParameter(req, "oldPassword");

        char[] oldAccountPassword = user != null ? user.getPassword() : admin != null ? admin.getPassword() : null;
        String email = user != null ? user.getEmail() : admin != null ? admin.getEmail() : null;

        if(securityService.equalsPassword(oldPassword, oldAccountPassword)){
            if(!PasswordValidator.validatePassword(req)){
                logger.info("Failed ChangePasswordButton, passwords didn't match. (Email: " + email + ")");
                throw new CommandException("ChangePasswordButton failed, new passwords don't match ", new RuntimeException());
            }
            char[] password = securityService.createPassword(HttpUtils.checkRequestParameter(req, "password"));
            updatePassword(user, admin, password);
        } else{
            logger.info("Failed ChangePasswordButton, old passwords wrong. (Email: " + email + ")");
            throw new CommandException("ChangePasswordButton failed, old passwords wrong", new RuntimeException());
        }

        logger.info("Password was changed. (Email: " + email + ")");
        req.getSession().invalidate();
        logger.info(email + " signOut");
        return CommandName.SIGN_OUT_BUTTON;
    }

    private void updatePassword(User user, Admin admin, char[] password){
        if (user != null){
            user.setPassword(password);
            try {
                userService.updateUser(user);
            } catch (RuntimeException exception){
                throw new CommandException("ChangePasswordButton failed", exception);
            }
            return;
        }
        if (admin != null){
            admin.setPassword(password);
            try {
                adminService.updatePassword(admin);
            } catch (ServiceException exception){
                throw new CommandException("ChangePasswordButton failed", exception);
            }
            return;
        }
    }

}
