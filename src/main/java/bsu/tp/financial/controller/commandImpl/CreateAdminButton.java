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
import com.google.protobuf.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class CreateAdminButton implements Command {

    private final Logger logger = LoggerFactory.getLogger(CreateAdminButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    AdminService adminService = serviceFactory.getAdminService();
    SecurityService securityService = serviceFactory.getSecurityService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        validation(req);
        Admin admin = createAdmin(req);
        try {
            adminService.signUp(admin);
        } catch (ServiceException exception) {
            throw new CommandException("CreateAdminButton failed ", exception);
        }
        logger.info(admin.getEmail() + " signUp");
        return CommandName.CREATE_ADMIN_BUTTON;
    }

    private Admin createAdmin(HttpServletRequest req) {
        Admin admin = new Admin();
        admin.setEmail(HttpUtils.checkRequestParameter(req, "email"));
        char[] password = securityService.createPassword(HttpUtils.checkRequestParameter(req, "password"));
        admin.setPassword(password);
        return admin;
    }

    private void validation(HttpServletRequest req) {
        if (HttpUtils.isMethodGet(req)) {
            logger.info("Failed, call method get in CreateAdminButton");
            throw new CommandException("CreateAdminButton failed", new RuntimeException());
        }

        if (!PasswordValidator.validatePassword(req)) {
            logger.info("Failed CreateAdminButton, passwords didn't match. (Email: " + req.getParameter("email") + ")");
            throw new CommandException("CreateAdminButton failed", new RuntimeException());
        }

        try {
            if (adminService.findAdminByEmail(HttpUtils.checkRequestParameter(req, "email")) != null) {
                throw new CommandException("CreateAdminButton failed, email already exists", new RuntimeException());
            }
        } catch (ServiceException exception) {
            throw new CommandException("CreateAdminButton failed, email already exists", exception);
        }
    }

}
