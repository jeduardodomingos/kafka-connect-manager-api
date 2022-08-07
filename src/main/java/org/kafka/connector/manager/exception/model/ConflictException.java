package org.kafka.connector.manager.exception.model;

public class ConflictException extends RuntimeException{

    private static final long serialVersionUID = -6492774410268514507L;

    private Integer code;

    public ConflictException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ConflictException() {
        super();
    }

    public Integer getCode() {
        return code;
    }
}
