package com.vahan.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by TCE\vahany on 3/31/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String type;
    private com.vahan.domain.Value value;

    public User() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public com.vahan.domain.Value getValue() {
        return value;
    }

    public void setValue(com.vahan.domain.Value value) {
        this.value = value;
    }
}
