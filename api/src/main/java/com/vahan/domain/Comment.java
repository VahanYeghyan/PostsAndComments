package com.vahan.domain;

import java.util.Date;

/**
 * Created by TCE\vahany on 3/31/17.
 */
public class Comment {

    private long id;
    private String content;
    private Date creationDate;

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
