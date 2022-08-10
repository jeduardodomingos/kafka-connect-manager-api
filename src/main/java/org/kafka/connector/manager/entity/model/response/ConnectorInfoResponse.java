package org.kafka.connector.manager.entity.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConnectorInfoResponse implements Serializable {

    private static final long serialVersionUID = -1526362813479592742L;

    private Map<String, String> config;
    private List<Map<String, Object>> tasks;
    private String type;

    public Map<String, String> getConfig() {
        return config;
    }

    public ConnectorInfoResponse setConfig(Map<String, String> config) {
        this.config = config;
        return this;
    }

    public List<Map<String, Object>> getTasks() {
        return tasks;
    }

    public ConnectorInfoResponse setTasks(List<Map<String, Object>> tasks) {
        this.tasks = tasks;
        return this;
    }

    public String getType() {
        return type;
    }

    public ConnectorInfoResponse setType(String type) {
        this.type = type;
        return this;
    }
}
