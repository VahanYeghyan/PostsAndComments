package com.vahan.domain;


import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by TCE\vahany on 3/29/17.
 */
public class Post {
    @Id
    private long id;
    private String description;

    private List<Comment> commentList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
