package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.Admin;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.CommandException;
import bsu.tp.financial.service.AdminService;
import bsu.tp.financial.service.SecurityService;
import bsu.tp.financial.service.ServiceFactory;
import bsu.tp.financial.service.UserService;
import bsu.tp.financial.util.HttpUtils;
import com.google.protobuf.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class SignInButton implements Command {

    private final Logger logger = LoggerFactory.getLogger(SignInButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();
    AdminService adminService = serviceFactory.getAdminService();
    SecurityService securityService = serviceFactory.getSecurityService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        if (HttpUtils.isMethodGet(req)) {
            logger.info("Failed, call method get in signInButton");
            throw new CommandException("SignInButton failed",  new RuntimeException());
        }

        String email = HttpUtils.checkRequestParameter(req, "email");
        String password = HttpUtils.checkRequestParameter(req, "password");

        try {
            if (signInUser(req, email, password)) {
                logger.info("User: " + email + " signIn.");
                return CommandName.PROFILE;
            }
            if (signInAdmin(req, email, password)) {
                logger.info("Admin: " + email + " signIn.");
                return CommandName.ADMIN_PROFILE;
            }
        } catch (RuntimeException | ServiceException exception) {
            throw new CommandException("Sign in failed ", exception);
        }

        logger.info("Invalid signIn information. (Email: " + email + ")");
        return CommandName.SIGN_IN_BUTTON;
    }

    private boolean signInUser(HttpServletRequest req, String email, String password) {
        User user = (User) userService.signIn(email);
        if (user != null && securityService.equalsPassword(password, user.getPassword())) {
            HttpUtils.updateSession(req, "user", user);
            return true;
        }
        return false;
    }

    private boolean signInAdmin(HttpServletRequest req, String email, String password) throws ServiceException {
        Admin admin = adminService.signIn(email);
        if (admin != null && securityService.equalsPassword(password, admin.getPassword())) {
            HttpUtils.updateSession(req, "admin", admin);
            return true;
        }
        return false;
    }
}
