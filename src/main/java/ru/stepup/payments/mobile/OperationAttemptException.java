package ru.stepup.payments.mobile;

public class OperationAttemptException extends Exception{
    public OperationAttemptException() {
    }

    public OperationAttemptException(String message) {
        super(message);
    }

    public OperationAttemptException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationAttemptException(Throwable cause) {
        super(cause);
    }

    public OperationAttemptException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

