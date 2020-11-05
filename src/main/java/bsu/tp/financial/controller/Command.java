package bsu.tp.financial.controller;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    CommandName callCommandMethod(HttpServletRequest req);
}
