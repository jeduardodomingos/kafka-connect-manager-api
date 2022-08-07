package org.kafka.connector.manager.model.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class DebeziumConnectorResponse implements Serializable {

    private static final long serialVersionUID = 3859963174090249649L;

    private String name;
    private Map<String, String> config;
    private List<Map<String, String>> tasks;

    public String getName() {
        return name;
    }

    public DebeziumConnectorResponse setName(String name) {
        this.name = name;
        return this;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public DebeziumConnectorResponse setConfig(Map<String, String> config) {
        this.config = config;
        return this;
    }

    public List<Map<String, String>> getTasks() {
        return tasks;
    }

    public DebeziumConnectorResponse setTasks(List<Map<String, String>> tasks) {
        this.tasks = tasks;
        return this;
    }
}
