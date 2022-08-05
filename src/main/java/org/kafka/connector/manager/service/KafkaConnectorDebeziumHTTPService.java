package org.kafka.connector.manager.service;

import org.kafka.connector.manager.abstractions.http.AbstractHttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class KafkaConnectorDebeziumHTTPService extends AbstractHttpService implements KafkaConnectorService  {

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConnectorDebeziumHTTPService.class);

    @Value("${kafka.connect.api.host}")
    private String kafkaConnectHost;

    @Autowired
    public KafkaConnectorDebeziumHTTPService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    public String[] listConnectors() {
        LOGGER.info("Listing connectors from the debezium deployment");
        HttpHeaders requestHeader = buildHeader(new LinkedMultiValueMap<>());
        return this.get(kafkaConnectHost, requestHeader, String[].class);
    }

}
