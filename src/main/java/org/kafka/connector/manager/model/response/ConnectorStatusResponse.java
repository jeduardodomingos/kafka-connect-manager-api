package org.kafka.connector.manager.model.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ConnectorStatusResponse implements Serializable {

    private static final long serialVersionUID = 4696349498525306262L;

    private String name;
    private String type;
    private Map<String, String> connector;
    private List<ConnectorTasksResponse> tasks;

    public String getName() {
        return name;
    }

    public ConnectorStatusResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public ConnectorStatusResponse setType(String type) {
        this.type = type;
        return this;
    }

    public Map<String, String> getConnector() {
        return connector;
    }

    public ConnectorStatusResponse setConnector(Map<String, String> connector) {
        this.connector = connector;
        return this;
    }

    public List<ConnectorTasksResponse> getTasks() {
        return tasks;
    }

    public ConnectorStatusResponse setTasks(List<ConnectorTasksResponse> tasks) {
        this.tasks = tasks;
        return this;
    }
}