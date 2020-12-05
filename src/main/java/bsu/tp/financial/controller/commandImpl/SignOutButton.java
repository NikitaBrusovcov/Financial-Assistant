package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;
import bsu.tp.financial.entity.Admin;
import bsu.tp.financial.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class SignOutButton implements Command {

    private final Logger logger = LoggerFactory.getLogger(SignOutButton.class);

    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        signOut(req);
        return CommandName.SIGN_OUT_BUTTON;
    }

    private void signOut(HttpServletRequest req){
        if(req.getSession().getAttribute("user") != null){
            signOutUser(req);
        }
        if(req.getSession().getAttribute("admin") != null){
            signOutAdmin(req);
        }
        req.getSession().invalidate();
    }

    private void signOutUser(HttpServletRequest req){
        User user = (User) req.getSession().getAttribute("user");
        logger.info("User: " + user.getEmail() + " sign out");
    }

    private void signOutAdmin(HttpServletRequest req){
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        logger.info("Admin: " + admin.getEmail() + " sign out");
    }
}
