package com.fisher.common.exception;

public class FisherException extends RuntimeException{

    private Integer code;
    private String errorMessage;

    public FisherException() {
    }

    public FisherException(String message) {
        super(message);
    }

    public FisherException(MessageExceptionEnum exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.errorMessage = exception.getMessage();
    }
}
