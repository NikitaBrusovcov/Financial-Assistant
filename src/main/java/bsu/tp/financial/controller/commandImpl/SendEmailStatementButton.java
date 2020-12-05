package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.service.AdminService;
import bsu.tp.financial.service.SecurityService;
import bsu.tp.financial.service.ServiceFactory;
import bsu.tp.financial.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class SendEmailStatementButton implements Command {
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();
    AdminService adminService = serviceFactory.getAdminService();
    SecurityService securityService = serviceFactory.getSecurityService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        
        return CommandName.BANK_ACCOUNTS_BUTTON;
    }
}
