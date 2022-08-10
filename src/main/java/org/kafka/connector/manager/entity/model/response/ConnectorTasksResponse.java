package org.kafka.connector.manager.entity.model.response;

import java.io.Serializable;

public class ConnectorTasksResponse implements Serializable {

    private static final long serialVersionUID = 4622774459693833182L;

    private Long id;
    private String state;
    private String trace;

    public Long getId() {
        return id;
    }

    public ConnectorTasksResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getState() {
        return state;
    }

    public ConnectorTasksResponse setState(String state) {
        this.state = state;
        return this;
    }

    public String getTrace() {
        return trace;
    }

    public ConnectorTasksResponse setTrace(String trace) {
        this.trace = trace;
        return this;
    }
}
