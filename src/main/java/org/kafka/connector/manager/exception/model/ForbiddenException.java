package org.kafka.connector.manager.exception.model;

public class ForbiddenException extends RuntimeException {

    private static final long serialVersionUID = 4706708993072780944L;

    private String code;

    public ForbiddenException(String message, String code) {
        super(message);
        this.code = code;
    }

    public ForbiddenException() {
        super();
    }

    public String getCode() {
        return code;
    }

}
