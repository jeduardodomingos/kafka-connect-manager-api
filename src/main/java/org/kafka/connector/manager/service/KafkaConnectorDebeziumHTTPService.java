package org.kafka.connector.manager.service;

import org.kafka.connector.manager.abstractions.http.AbstractHttpService;
import org.kafka.connector.manager.exception.handler.DebeziumAPIHttpExceptionHandler;
import org.kafka.connector.manager.model.request.ConnectorRequest;
import org.kafka.connector.manager.model.response.ConnectorResponse;
import org.kafka.connector.manager.model.response.ConnectorStatusResponse;
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
    public KafkaConnectorDebeziumHTTPService(RestTemplate restTemplate, DebeziumAPIHttpExceptionHandler httpExceptionHandler) {
        super(restTemplate, httpExceptionHandler);
    }

    public String[] listConnectors() {
        LOGGER.info("KafkaConnectorDebeziumHTTPService.listConnectors");
        HttpHeaders requestHeader = buildHeader(new LinkedMultiValueMap<>());
        return this.get(String.format("%1$s/connectors", kafkaConnectHost), requestHeader, String[].class);
    }

    public ConnectorResponse createConnector(ConnectorRequest request) {
        LOGGER.info("KafkaConnectorDebeziumHTTPService.createConnector");
        HttpHeaders requestHeader = buildHeader(new LinkedMultiValueMap<>());
        return this.post(String.format("%1$s/connectors", kafkaConnectHost), request, requestHeader, ConnectorResponse.class);
    }

    public void restartConnector(String connectorName) {
        LOGGER.info("KafkaConnectorDebeziumHTTPService.restartConnector");
        HttpHeaders requestHeader = buildHeader(new LinkedMultiValueMap<>());
        this.post(String.format("%1$s/connectors/%2$s/restart", kafkaConnectHost, connectorName), requestHeader, String.class);
    }

    public void restartAllFailedTasks(String connectorName) {
        LOGGER.info("KafkaConnectorDebeziumHTTPService.connectorName");
        HttpHeaders requestHeader = buildHeader(new LinkedMultiValueMap<>());
        this.post(String.format("%1$s/connectors/%2$s/restart?includeTasks=true&onlyFailed=true", kafkaConnectHost, connectorName), requestHeader, String.class);
    }

    public ConnectorStatusResponse getConnectorStatus(String connectorName) {
        LOGGER.info("KafkaConnectorDebeziumHTTPService.getConnectorStatus");
        HttpHeaders requestHeader = buildHeader(new LinkedMultiValueMap<>());
        return this.get(String.format("%1$s/connectors/%2$s/status", kafkaConnectHost, connectorName), requestHeader, ConnectorStatusResponse.class);
    }


}
