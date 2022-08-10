package org.kafka.connector.manager.entity.model.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ConnectorResponse implements Serializable {

    private static final long serialVersionUID = 3859963174090249649L;

    private String name;
    private Map<String, String> config;
    private List<Map<String, String>> tasks;

    public String getName() {
        return name;
    }

    public ConnectorResponse setName(String name) {
        this.name = name;
        return this;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public ConnectorResponse setConfig(Map<String, String> config) {
        this.config = config;
        return this;
    }

    public List<Map<String, String>> getTasks() {
        return tasks;
    }

    public ConnectorResponse setTasks(List<Map<String, String>> tasks) {
        this.tasks = tasks;
        return this;
    }
}
