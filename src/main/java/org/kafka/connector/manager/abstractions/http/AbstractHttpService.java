package org.kafka.connector.manager.abstractions.http;

import org.kafka.connector.manager.exception.handler.DebeziumAPIHttpExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

public abstract class AbstractHttpService {

    private final Logger LOGGER = LoggerFactory.getLogger(AbstractHttpService.class);

    protected RestTemplate restTemplate;

    public AbstractHttpService(RestTemplate restTemplate, DefaultResponseErrorHandler errorHandler) {
        this.restTemplate = restTemplate;
        this.restTemplate.setErrorHandler(errorHandler);
    }

    protected <T> T get(String url, HttpHeaders httpHeaders, Class<T> responseType) {
        LOGGER.info("AbstractHttpService.get for url {}", url);
        return this.restTemplate.exchange(url, GET, new HttpEntity<>(httpHeaders), responseType).getBody();
    }

    protected <T> T post(String url, Object body, HttpHeaders httpHeaders, Class<T> responseType) {
        LOGGER.info("AbstractHttpService.post for url {}", url);
        return this.restTemplate.exchange(url, POST, new HttpEntity<>(body, httpHeaders), responseType).getBody();
    }

    protected <T> T post(String url, HttpHeaders httpHeaders, Class<T> responseType) {
        LOGGER.info("AbstractHttpService.post for url {}", url);
        return this.restTemplate.exchange(url, POST, new HttpEntity<>(httpHeaders), responseType).getBody();
    }

    protected <T> T put(String url, Object body, HttpHeaders httpHeaders, Class<T> responseType) {
        LOGGER.info("AbstractHttpService.put for url {}", url);
        return this.restTemplate.exchange(url, PUT, new HttpEntity<>(body, httpHeaders), responseType).getBody();
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
