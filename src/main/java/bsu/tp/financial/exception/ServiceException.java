package bsu.tp.financial.exception;

public class ServiceException extends RuntimeException{
    public ServiceException(String message, Throwable exception) {
        super(message, exception);
    }
}
