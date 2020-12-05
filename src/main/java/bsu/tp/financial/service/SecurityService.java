package bsu.tp.financial.service;

public interface SecurityService {
    public boolean equalsPassword(String firstPassword, char[] secondPassword);
    public char[] createPassword(String password);
}
