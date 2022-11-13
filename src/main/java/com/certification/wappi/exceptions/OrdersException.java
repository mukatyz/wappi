package com.certification.wappi.exceptions;

public class OrdersException extends AssertionError{
    public OrdersException(Object detailMessage) {
        super(detailMessage);
    }

    public OrdersException(String message, Throwable cause) {
        super(message, cause);
    }
}
