package org.kafka.connector.manager.exception.handler;

import org.kafka.connector.manager.exception.model.ForbiddenException;
import org.kafka.connector.manager.exception.model.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

public class HttpExceptionHandler extends DefaultResponseErrorHandler {

    @Override
    protected void handleError(ClientHttpResponse response, HttpStatus code) throws IOException {
        switch (code){
            case NOT_FOUND:
                throw new NotFoundException();
            case FORBIDDEN:
                throw new ForbiddenException();
            default:
                throw new RuntimeException();
        }
    }

}
