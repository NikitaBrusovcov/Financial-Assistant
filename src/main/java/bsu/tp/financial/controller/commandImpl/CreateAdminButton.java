package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.Admin;
import bsu.tp.financial.entity.BankAccount;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.CommandException;
import bsu.tp.financial.service.*;
import bsu.tp.financial.util.HttpUtils;
import bsu.tp.financial.util.PasswordValidator;

import javax.servlet.http.HttpServletRequest;

public class CreateAdminButton implements Command {

    //private final Logger logger = LoggerFactory.getLogger(SignUpButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    AdminService adminService = serviceFactory.getAdminService();
    SecurityService securityService = serviceFactory.getSecurityService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        if (HttpUtils.isMethodGet(req)) {
            //logger.info("Failed, call method get in signUp page.");
            //return CommandName.ERROR.getCommand().callCommandMethod(req);
        }
        if(!PasswordValidator.validatePassword(req)){
            //logger.info("Failed signUp, passwords didn't match. (Email: " + req.getParameter("email") + ")");
            req.setAttribute("wrongInformation", true);
            return CommandName.CREATE_ADMIN_BUTTON;
        }
        if(adminService.findAdminByEmail(HttpUtils.checkRequestParameter(req, "email")) != null){
            throw new CommandException("signUp failed, email was founded" , new RuntimeException());
        }
        Admin admin = createAdmin(req);
        try {
            adminService.signUp(admin);
        } catch (RuntimeException exception) {
            //throw new CommandException("Sign up failed ", exception);
        }
        return CommandName.CREATE_ADMIN_BUTTON;
    }

    private Admin createAdmin(HttpServletRequest req) {
        Admin admin = new Admin();
        admin.setEmail(HttpUtils.checkRequestParameter(req, "email"));
        char[] password = securityService.createPassword(HttpUtils.checkRequestParameter(req, "password"));
        admin.setPassword(password);
        return admin;
    }
}
