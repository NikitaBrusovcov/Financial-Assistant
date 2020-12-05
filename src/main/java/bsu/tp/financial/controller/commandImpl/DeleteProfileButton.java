package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.User;
import bsu.tp.financial.service.BankAccountService;
import bsu.tp.financial.service.SecurityService;
import bsu.tp.financial.service.ServiceFactory;
import bsu.tp.financial.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class DeleteProfileButton implements Command {
    //private final Logger logger = LoggerFactory.getLogger(SignUpButton.class);

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    UserService userService = serviceFactory.getUserService();
    BankAccountService bankAccountService = serviceFactory.getBankAccountService();
    SecurityService securityService = serviceFactory.getSecurityService();

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        userService.deleteUser(user);
        req.getSession().invalidate();
        return CommandName.SIGN_OUT_BUTTON;
    }
}
