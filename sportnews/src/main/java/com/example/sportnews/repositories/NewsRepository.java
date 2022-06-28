package com.example.sportnews.repositories;

import com.example.sportnews.repositories.models.NewsDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository {


    NewsDAO createNews(String title, String content, String category, Integer user_id, String image_url);

    NewsDAO getNews(Integer id);
    List<NewsDAO> listNews(Integer page, Integer pageSize);

    List<NewsDAO> listNewsByCategory(Integer page, Integer pageSize, String category);

    List<NewsDAO> listNewsByTag(Integer page, Integer pageSize, String category);

    void deleteNews(int id);

}
