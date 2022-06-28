package com.example.sportnews.repositories.models;

public class TagToNewsDAO {

    public final Integer news_id;
    public final Integer tag_id;

    public String tag_name;



    public TagToNewsDAO(Integer news_id, Integer tag_id) {
        this.news_id = news_id;
        this.tag_id = tag_id;
    }
    public TagToNewsDAO(Integer news_id, Integer tag_id, String tag_name) {
        this.news_id = news_id;
        this.tag_id = tag_id;
        this.tag_name = tag_name;
    }

}
