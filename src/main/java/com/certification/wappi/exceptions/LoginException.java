package com.certification.wappi.exceptions;

public class LoginException extends AssertionError{
    public LoginException(Object detailMessage) {
        super(detailMessage);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
