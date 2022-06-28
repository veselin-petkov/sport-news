package com.example.sportnews.repositories.models;

public class TagDAO {

    public final Integer id;
    public final String tag_name;

    public TagDAO(Integer id, String tag_name) {
        this.id = id;
        this.tag_name = tag_name;
    }

}
