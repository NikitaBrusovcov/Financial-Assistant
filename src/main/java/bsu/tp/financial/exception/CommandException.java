package bsu.tp.financial.exception;

public class CommandException extends RuntimeException{
    public CommandException(String message, Throwable exception) {
        super(message, exception);
    }
}
