package org.kafka.connector.manager.exception.model;

public class ForbiddenException extends RuntimeException {

    private static final long serialVersionUID = 4706708993072780944L;

    private Integer code;

    public ForbiddenException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ForbiddenException() {
        super();
    }



}
