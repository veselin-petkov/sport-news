package com.example.sportnews.repositories.models;

import java.sql.Timestamp;

public class CommentDAO {

    public final Integer id;
    public final Integer user_id;
    public final String content;
    public final Timestamp date;
    public final Integer news_id;

    public CommentDAO(Integer id, Integer user_id, String content, Timestamp date, Integer news_id) {
        this.id = id;
        this.user_id = user_id;
        this.content = content;
        this.date = date;
        this.news_id = news_id;
    }
}
