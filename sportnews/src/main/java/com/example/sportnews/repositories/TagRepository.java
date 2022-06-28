package com.example.sportnews.repositories;

import com.example.sportnews.repositories.models.TagDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository {

    TagDAO createTag(String tag_name);

    TagDAO getTag(Integer id);

    List<TagDAO> listTags(int page, int pageSize);

    void deleteTag(Integer id);


}
