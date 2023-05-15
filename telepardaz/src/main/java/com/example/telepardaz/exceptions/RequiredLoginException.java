package com.example.telepardaz.exceptions;

public class RequiredLoginException extends ServiceException {
    public RequiredLoginException(String errorCode) {
        super(errorCode);
    }

    public RequiredLoginException(String message, String errorCode) {
        super(message, errorCode);
    }

    public RequiredLoginException(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }

    public RequiredLoginException(Throwable cause, String errorCode) {
        super(cause, errorCode);
    }

    public RequiredLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode) {
        super(message, cause, enableSuppression, writableStackTrace, errorCode);
    }
}
