package org.kafka.connector.manager.entity.model.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ConnectorStatusResponse implements Serializable {

    private static final long serialVersionUID = 4696349498525306262L;

    private Map<String, Object> connector;
    private List<Map<String, Object>> tasks;

    public Map<String, Object> getConnector() {
        return connector;
    }

    public ConnectorStatusResponse setConnector(Map<String, Object> connector) {
        this.connector = connector;
        return this;
    }

    public List<Map<String, Object>> getTasks() {
        return tasks;
    }

    public ConnectorStatusResponse setTasks(List<Map<String, Object>> tasks) {
        this.tasks = tasks;
        return this;
    }
}