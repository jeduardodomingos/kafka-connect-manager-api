package org.kafka.connector.manager.entity.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConnectorFullResponse implements Serializable {

    private static final long serialVersionUID = 8635489880829876647L;

    private String name;
    private ConnectorInfoResponse info;
    private ConnectorStatusResponse status;

    public String getName() {
        return name;
    }

    public ConnectorFullResponse setName(String name) {
        this.name = name;
        return this;
    }

    public ConnectorInfoResponse getInfo() {
        return info;
    }

    public ConnectorFullResponse setInfo(ConnectorInfoResponse info) {
        this.info = info;
        return this;
    }

    public ConnectorStatusResponse getStatus() {
        return status;
    }

    public ConnectorFullResponse setStatus(ConnectorStatusResponse status) {
        this.status = status;
        return this;
    }
}
