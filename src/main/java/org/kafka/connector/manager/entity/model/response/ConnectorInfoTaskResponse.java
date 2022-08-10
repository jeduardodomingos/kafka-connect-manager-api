package org.kafka.connector.manager.entity.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConnectorInfoTaskResponse implements Serializable {

    private static final long serialVersionUID = -5828123460896382929L;

    private String connector;
    private Long task;

    public String getConnector() {
        return connector;
    }

    public ConnectorInfoTaskResponse setConnector(String connector) {
        this.connector = connector;
        return this;
    }

    public Long getTask() {
        return task;
    }

    public ConnectorInfoTaskResponse setTask(Long task) {
        this.task = task;
        return this;
    }
}
