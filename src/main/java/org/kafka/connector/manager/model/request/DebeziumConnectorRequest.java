package org.kafka.connector.manager.model.request;

import java.io.Serializable;
import java.util.Map;

public class DebeziumConnectorRequest implements Serializable {

    private static final long serialVersionUID = 3859963174090249649L;

    private String name;

    private Map<String, String> config;

    public String getName() {
        return name;
    }

    public DebeziumConnectorRequest setName(String name) {
        this.name = name;
        return this;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public DebeziumConnectorRequest setConfig(Map<String, String> config) {
        this.config = config;
        return this;
    }
}
