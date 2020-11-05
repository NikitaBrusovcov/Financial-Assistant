package bsu.tp.financial.controller.commandImpl;

import bsu.tp.financial.controller.Command;
import bsu.tp.financial.controller.CommandName;

import javax.servlet.http.HttpServletRequest;

public class SignInButton implements Command {
    @Override
    public CommandName callCommandMethod(HttpServletRequest req) {
        return null;
    }
}
