package com.example.sportnews.core.models;

public class TagToNews {


    public Integer news_id;

    public  Integer tag_id;

    public String tag_name;


    public TagToNews() {
    }

    public TagToNews(Integer news_id, Integer tag_id) {
        this.news_id = news_id;
        this.tag_id = tag_id;
    }

    public TagToNews(Integer news_id, Integer tag_id, String tag_name) {
        this.news_id = news_id;
        this.tag_id = tag_id;
        this.tag_name = tag_name;
    }

    @Override
    public String toString() {
        return "TagToNews{" +
                "news_id=" + news_id +
                ", tag_id=" + tag_id +
                ", tag_name='" + tag_name + '\'' +
                '}';
    }
}
