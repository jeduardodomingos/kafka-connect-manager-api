package org.kafka.connector.manager.entity.model.response;

public class ErrorResponse {

    private String code;
    private String message;
    private String source;

    public ErrorResponse(String code, String message, String source) {
        this.code = code;
        this.message = message;
        this.source = source;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getSource() {
        return source;
    }
}
