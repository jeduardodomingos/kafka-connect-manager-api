package org.kafka.connector.manager.service;

import org.kafka.connector.manager.exception.handler.HttpExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.kafka.connector.manager.abstractions.http.AbstractHttpService;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class RestHttpService extends AbstractHttpService {

    private final Logger LOGGER = LoggerFactory.getLogger(RestHttpService.class);

    protected RestTemplate restTemplate;

    public RestHttpService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.restTemplate.setErrorHandler(new HttpExceptionHandler());
    }

    public MultiValueMap<String, String> buildBearerAuthorizationHeader(String token) {
        LOGGER.info("Making Authentication Header");

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", "Bearer ".concat(token));

        return headers;
    }

    public HttpHeaders buildHeader(MultiValueMap<String,String> headers) {
        LOGGER.info("Making Internal Authentication Headers.");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(APPLICATION_JSON);
        httpHeaders.addAll(headers);

        return httpHeaders;
    }
}
