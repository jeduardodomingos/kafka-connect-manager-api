package org.kafka.connector.manager.exception.model;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4706708993072780944L;;

    private String code;

    public NotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }

    public NotFoundException() {
        super();
    }

    public String getCode() {
        return code;
    }
}
