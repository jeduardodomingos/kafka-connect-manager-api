package org.kafka.connector.manager.abstractions.http;

import org.kafka.connector.manager.exception.handler.HttpExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpMethod.GET;

public abstract class AbstractHttpService {

    private final Logger LOGGER = LoggerFactory.getLogger(AbstractHttpService.class);

    protected RestTemplate restTemplate;

    public AbstractHttpService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.restTemplate.setErrorHandler(new HttpExceptionHandler());
    }

    protected <T> T get(String url, HttpHeaders httpHeaders, Class<T> responseType) {
        LOGGER.info("Making a GET HTTP request");
        return this.restTemplate.exchange(url, GET, new HttpEntity<>(httpHeaders), responseType).getBody();
    }

    protected <T> Object post(String url, Object body, HttpHeaders httpHeaders, Class<T> responseType) {
        LOGGER.info("Making a GET HTTP request");
        return this.restTemplate.exchange(url, POST, new HttpEntity<>(body, httpHeaders), responseType);
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
