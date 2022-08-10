package org.kafka.connector.manager.entity.model.request;

import java.io.Serializable;
import java.util.Map;

public class ConnectorRequest implements Serializable {

    private static final long serialVersionUID = 3859963174090249649L;

    private String name;

    private Map<String, String> config;

    public String getName() {
        return name;
    }

    public ConnectorRequest setName(String name) {
        this.name = name;
        return this;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public ConnectorRequest setConfig(Map<String, String> config) {
        this.config = config;
        return this;
    }
}
