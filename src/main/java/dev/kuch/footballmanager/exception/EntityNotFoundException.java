package dev.kuch.footballmanager.exception;

/**
 * @author Artur Kuch
 */

public class EntityNotFoundException extends ServiceException{

    private static final String DEFAULT_MESSAGE = "Entity not found";

    public EntityNotFoundException() {super(DEFAULT_MESSAGE);}

    public EntityNotFoundException(String message) {super(message);}

    @Override
    public ErrorType getErrorType() {return ErrorType.VALIDATION_ERROR_TYPE;}


}
