package org.kafka.connector.manager.service;

import org.kafka.connector.manager.abstractions.http.AbstractHttpService;
import org.kafka.connector.manager.model.request.DebeziumConnectorRequest;
import org.kafka.connector.manager.model.response.DebeziumConnectorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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
        LOGGER.info("KafkaConnectorDebeziumHTTPService.listConnectors");
        HttpHeaders requestHeader = buildHeader(new LinkedMultiValueMap<>());
        return this.get(String.format("%1$s/connectors", kafkaConnectHost), requestHeader, String[].class);
    }

    public Object createConnector(DebeziumConnectorRequest request) {
        LOGGER.info("KafkaConnectorDebeziumHTTPService.createConnector");
        HttpHeaders requestHeader = buildHeader(new LinkedMultiValueMap<>());
        return this.post(String.format("%1$s/connectors", kafkaConnectHost), request, requestHeader, DebeziumConnectorResponse.class);
    }
}
