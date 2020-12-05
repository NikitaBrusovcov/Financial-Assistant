package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.Admin;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.CommandException;
import bsu.tp.financial.service.*;
import bsu.tp.financial.util.HttpUtils;
import bsu.tp.financial.util.PasswordValidator;

import javax.servlet.http.HttpServletRequest;

public class ChangePasswordButton implements Command {
    //private final Logger logger = LoggerFactory.getLogger(SignUpButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();
    AdminService adminService = serviceFactory.getAdminService();
    BankAccountService bankAccountService = serviceFactory.getBankAccountService();
    SecurityService securityService = serviceFactory.getSecurityService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        if (HttpUtils.isMethodGet(req)) {
            //logger.info("Failed, call method get in signUp page.");
            //return CommandName.ERROR.getCommand().callCommandMethod(req);
        }

        User user = (User) req.getSession().getAttribute("user");
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        String oldPassword = HttpUtils.checkRequestParameter(req, "oldPassword");
        if(securityService.equalsPassword(oldPassword, user.getPassword())){
            if(!PasswordValidator.validatePassword(req)){
                //logger.info("Failed signUp, passwords didn't match. (Email: " + req.getParameter("email") + ")");
                throw new CommandException("Change password failed, new passwords do not match ", new RuntimeException());
            }
            char[] password = securityService.createPassword(HttpUtils.checkRequestParameter(req, "password"));

        }
        else{
            //logger.info("Failed signUp, passwords didn't match. (Email: " + req.getParameter("email") + ")");
            throw new CommandException("Change password failed, old passwords do not match ", new RuntimeException());
        }
        req.getSession().invalidate();
        return CommandName.SIGN_OUT_BUTTON;
    }

    private void updatePassword(User user, Admin admin, char[] password){
        if (user != null){
            user.setPassword(password);
            userService.updateUser(user);
            return;
        }
        if (admin != null){
            admin.setPassword(password);
            adminService.updatePassword(admin);
            return;
        }
    }
}
