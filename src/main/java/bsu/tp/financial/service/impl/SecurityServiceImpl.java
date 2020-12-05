package bsu.tp.financial.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bsu.tp.financial.service.SecurityService;

public class SecurityServiceImpl implements SecurityService{
    @Override
    public char[] createPassword(String password){
        return BCrypt.withDefaults().hashToChar(12, password.toCharArray());
    }

    @Override
    public boolean equalsPassword(String firstPassword, char[] secondPassword){
        return BCrypt.verifyer().verify(firstPassword.toCharArray(), secondPassword).verified;
    }
}
