package com.certification.wappi.exceptions;

public class CouponException extends AssertionError{
    public CouponException(String errorMessage){
        super(errorMessage);
    }

    public CouponException(String message, Throwable cause) {
        super(message, cause);
    }
}
