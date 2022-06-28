package com.example.sportnews.repositories.models;

import java.sql.Timestamp;

public class NewsDAO {

    public final Integer id;
    public final String title;
    public final String content;
    public final Timestamp date;
    public String category;
    public final Integer user_id;
    public final String image_url;


    public NewsDAO(Integer id, String title, String content, Timestamp date, String category, Integer user_id, String image_url) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.category = category;
        this.user_id = user_id;
        this.image_url = image_url;
    }

    public NewsDAO(Integer id, String title, String content, Timestamp date, Integer user_id, String image_url) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.user_id = user_id;
        this.image_url = image_url;
    }
}
