package com.example.sportnews.core.models;

public class Tag {

    public final Integer id;
    public final String tag_name;

    public Tag(Integer id, String tag_name) {
        this.id = id;
        this.tag_name = tag_name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tag_name='" + tag_name + '\'' +
                '}';
    }
}
