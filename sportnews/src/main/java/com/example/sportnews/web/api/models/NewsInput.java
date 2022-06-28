package com.example.sportnews.web.api.models;

public class NewsInput {
    public final String title;
    public final String content;
    public final String category;
    public final String image_url;


    public NewsInput(String title, String content, String category, String image_url) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.image_url = image_url;
    }
}
