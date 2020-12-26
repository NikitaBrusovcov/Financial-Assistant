package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.exception.CommandException;
import bsu.tp.financial.exception.ServiceException;
import bsu.tp.financial.service.*;
import bsu.tp.financial.service.impl.SecurityServiceImpl;
import bsu.tp.financial.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class ForgotPasswordButton implements Command {

    private final Logger logger = LoggerFactory.getLogger(ForgotPasswordButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();
    MailService mailService = serviceFactory.getMailService();
    AdminService adminService = serviceFactory.getAdminService();
    SecurityService securityService = serviceFactory.getSecurityService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        if (HttpUtils.isMethodGet(req)) {
            logger.info("Failed, call method get in ForgotPasswordButton");
            throw new CommandException("ForgotPasswordButton failed",  new RuntimeException());
        }

        String email = HttpUtils.checkRequestParameter(req, "email");
        String password = newPassword(6);
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        char[] newPassword = securityService.createPassword(password);

        try {
            User user = userService.findUserByEmail(email);
            if(user != null){
                user.setPassword(newPassword);
                userService.updateUser(user);
                mailService.sendMail("New password", password, user.getEmail());
            }
            else{
                logger.info("Failed ForgotPasswordButton, user does not exist. (Email: " + email + ")");
                throw new CommandException("ForgotPasswordButton failed", new RuntimeException());

            }

        } catch (ServiceException exception){
            throw new CommandException("ForgotPasswordButton failed ", exception);
        }


        logger.info("Invalid signIn information. (Email: " + email + ")");
        return CommandName.SIGN_IN_BUTTON;
    }

    private String newPassword(int size){
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < size; i++){
            password.append('a');
        }
        return password.toString();
    }
}
