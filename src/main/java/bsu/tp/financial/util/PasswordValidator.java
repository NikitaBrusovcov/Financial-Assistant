package bsu.tp.financial.util;

import javax.servlet.http.HttpServletRequest;

public class PasswordValidator {
    public static boolean validatePassword(HttpServletRequest req) {
        String password = HttpUtils.checkRequestParameter(req, "password");
        String repeatPassword = HttpUtils.checkRequestParameter(req, "repeatPassword");
        return (password.equals(repeatPassword) && password.length() > 5);
    }
}
