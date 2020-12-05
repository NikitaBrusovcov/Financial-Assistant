package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.Admin;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.service.AdminService;
import bsu.tp.financial.service.SecurityService;
import bsu.tp.financial.service.ServiceFactory;
import bsu.tp.financial.service.UserService;
import bsu.tp.financial.util.HttpUtils;

import javax.servlet.http.HttpServletRequest;

public class SignInButton implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();
    AdminService adminService = serviceFactory.getAdminService();
    SecurityService securityService = serviceFactory.getSecurityService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        if (HttpUtils.isMethodGet(req)) {
            //logger.info("Failed, call method get in signIn page.");
            //return CommandName.ERROR.getCommand().callCommandMethod(req);
        }

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            if (signInUser(req, email, password)) {
                //logger.info("User: " + email + " sign in.");
                return CommandName.PROFILE;
            }
            if (signInAdmin(req, email, password)) {
                //logger.info("Admin: " + email + " sign in.");
                return CommandName.ADMIN_PROFILE;
                //return CommandName.EDIT_ADMIN_INFORMATION_BUTTON;
            }
        } catch (RuntimeException exception) {
            //throw new CommandException("Sign in failed ", exception);
        }

        //logger.info("Invalid signIn information. (Email: " + req.getParameter("email") + ")");
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

    private boolean signInAdmin(HttpServletRequest req, String email, String password) {
        Admin admin = adminService.signIn(email);
        if (admin != null && securityService.equalsPassword(password, admin.getPassword())) {
            HttpUtils.updateSession(req, "admin", admin);
            return true;
        }
        return false;
    }
}
