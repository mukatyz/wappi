package com.certification.wappi.exceptions;

public class ProfileException extends AssertionError{
    public ProfileException(Object detailMessage) {
        super(detailMessage);
    }

    public ProfileException(String message, Throwable cause) {
        super(message, cause);
    }
}
