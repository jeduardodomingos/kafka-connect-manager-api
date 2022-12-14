package org.kafka.connector.manager.exception.model;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4706708993072780944L;;

    private Integer code;

    public NotFoundException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public NotFoundException() {
        super();
    }

    public Integer getCode() {
        return code;
    }
}
