package org.kafka.connector.manager.controller;

import org.kafka.connector.manager.model.request.ConnectorRequest;
import org.kafka.connector.manager.model.response.ConnectorResponse;
import org.kafka.connector.manager.model.response.ConnectorStatusResponse;
import org.kafka.connector.manager.service.KafkaConnectorDebeziumHTTPService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/v1/debezium")
public class KafkaConnectorDebeziumController {

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConnectorDebeziumController.class);

    private KafkaConnectorDebeziumHTTPService debeziumHTTPService;

    public KafkaConnectorDebeziumController(KafkaConnectorDebeziumHTTPService debeziumHTTPService) {
        LOGGER.info("Initializing KafkaConnectorDebeziumController");
        this.debeziumHTTPService = debeziumHTTPService;
    }

    @GetMapping
    @ResponseStatus(OK)
    public String[] listConnectors(){
        LOGGER.info("KafkaConnectorDebeziumController.listConnectors");
        return this.debeziumHTTPService.listConnectors();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ConnectorResponse createConnector(@RequestBody ConnectorRequest request) {
        LOGGER.info("Initializing KafkaConnectorDebeziumController.createConnector");
        return this.debeziumHTTPService.createConnector(request);
    }

    @PostMapping("/{connectorName}/restart")
    @ResponseStatus(OK)
    public void restartConnector(@PathVariable("connectorName") String connectorName) {
        LOGGER.info("Initializing KafkaConnectorDebeziumController.restartConnector");
        this.debeziumHTTPService.restartConnector(connectorName);
    }

    @PostMapping("/{connectorName}/restart/failedTasks")
    @ResponseStatus(OK)
    public void restartConnectorFailedTasks(@PathVariable("connectorName") String connectorName) {
        LOGGER.info("Initializing KafkaConnectorDebeziumController.restartConnector");
        this.debeziumHTTPService.restartAllFailedTasks(connectorName);
    }

    @GetMapping("/{connectorName}/status")
    @ResponseStatus(OK)
    public ConnectorStatusResponse getConnectorStatus(@PathVariable("connectorName") String connectorName) {
        LOGGER.info("Initializing KafkaConnectorDebeziumController.getConnectorStatus");
        return this.debeziumHTTPService.getConnectorStatus(connectorName);
    }
}
