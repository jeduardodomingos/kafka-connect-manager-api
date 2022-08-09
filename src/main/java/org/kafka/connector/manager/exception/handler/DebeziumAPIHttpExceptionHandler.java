package org.kafka.connector.manager.exception.handler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kafka.connector.manager.exception.model.ConflictException;
import org.kafka.connector.manager.exception.model.ForbiddenException;
import org.kafka.connector.manager.exception.model.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class DebeziumAPIHttpExceptionHandler extends DefaultResponseErrorHandler {

    @Override
    protected void handleError(ClientHttpResponse response, HttpStatus code) throws IOException {
        switch (code){
            case NOT_FOUND:
                throw new NotFoundException(parseResponse(response.getBody()), response.getRawStatusCode());
            case FORBIDDEN:
                throw new ForbiddenException(parseResponse(response.getBody()), response.getRawStatusCode());
            case CONFLICT:
                throw new ConflictException(parseResponse(response.getBody()), response.getRawStatusCode());
            default:
                throw new RuntimeException(parseResponse(response.getBody()));
        }
    }

    private static String parseResponse(InputStream body) {
        String result = "";

        try {
            String content = new BufferedReader(new InputStreamReader(body)).lines().collect(Collectors.joining(" "));
            JsonNode object =  new ObjectMapper().readTree(content);

            result = object.get("message").toString().replace("\"", "");
        }catch (Exception ignored) {}

        return result;
    }

}
