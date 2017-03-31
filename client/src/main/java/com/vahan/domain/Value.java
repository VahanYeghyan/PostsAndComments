package com.vahan.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by TCE\vahany on 3/31/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

    private long id;
    private String name;
    private String password;

    public Value() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

