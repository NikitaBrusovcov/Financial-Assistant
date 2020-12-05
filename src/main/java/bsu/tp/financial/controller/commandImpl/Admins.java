package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.Admin;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Admins implements Command {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    AdminService adminService = serviceFactory.getAdminService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        List<Admin> admins = adminService.findAllAdmins();
        req.setAttribute("admins", admins);
        return CommandName.ADMINS;
    }
}
