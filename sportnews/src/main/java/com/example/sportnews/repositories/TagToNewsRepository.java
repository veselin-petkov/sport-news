package com.example.sportnews.repositories;


import com.example.sportnews.repositories.models.TagToNewsDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagToNewsRepository {


    TagToNewsDAO crateNewsToTags(Integer news_id, Integer tag_id);


    List<TagToNewsDAO> listNewsToTags(int page, int pageSize);

    List<TagToNewsDAO> findByTagId(Integer id);
    
    List<TagToNewsDAO> findByNewsId(Integer id);

    void deleteByTagId(Integer id);

    void deleteByNewsId(Integer id);
}
