package com.example.sportnews.core.models;

import java.sql.Timestamp;

public class News {

    public final Integer id;
    public final String title;
    public final String content;
    public final Timestamp date;
    public final String category;
    public final Integer user_id;

    public final String image_url;

    public News(Integer id, String title, String content, Timestamp date, String category, Integer user_id, String image_url) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.category = category;
        this.user_id = user_id;
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", category='" + category + '\'' +
                ", user_id=" + user_id +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
