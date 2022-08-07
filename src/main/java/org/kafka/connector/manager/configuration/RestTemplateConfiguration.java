package org.kafka.connector.manager.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    private final RestTemplateBuilder templateBuilder;

    @Autowired
    public RestTemplateConfiguration(RestTemplateBuilder templateBuilder) {
        this.templateBuilder = templateBuilder;
    }

    @Bean
    public RestTemplate restTemplate() {
        return templateBuilder
                .requestFactory(HttpComponentsClientHttpRequestFactory.class)
                .build();
    }
}
