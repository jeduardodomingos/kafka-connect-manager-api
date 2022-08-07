package org.kafka.connector.manager.controller;

import org.kafka.connector.manager.model.request.DebeziumConnectorRequest;
import org.kafka.connector.manager.model.response.DebeziumConnectorResponse;
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
        return debeziumHTTPService.listConnectors();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Object createConnector(@RequestBody DebeziumConnectorRequest request) {
        LOGGER.info("Initializing KafkaConnectorDebeziumController.createConnector");
        return debeziumHTTPService.createConnector(request);
    }
}
