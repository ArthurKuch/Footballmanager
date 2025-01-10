package dev.kuch.footballmanager.exception;

/**
 * @author Artur Kuch
 */

public class ServiceException extends RuntimeException {

    private ErrorType errorType;

    public ServiceException(String errorMessage) {
        super(errorMessage);
    }

    public ErrorType getErrorType() {
        return ErrorType.FATAL_ERROR_TYPE;
    }

}
