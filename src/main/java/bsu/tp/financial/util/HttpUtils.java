package bsu.tp.financial.util;

import bsu.tp.financial.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public class HttpUtils {

    public static<T> void updateSession(HttpServletRequest req, String sessionAttributeName, T sessionAttribute){
        req.getSession().setAttribute(sessionAttributeName, sessionAttribute);
    }

    public static boolean isMethodPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("post");
    }

    public static boolean isMethodGet(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("get");
    }

    public static String checkRequestParameter(HttpServletRequest req, String parameter){
        if(req.getParameter(parameter) == null){
            throw new CommandException("Command failed, " + parameter + " - null ", new RuntimeException());
        }
        else{
            return (req.getParameter(parameter));
        }
    }
    //public static boolean
}
