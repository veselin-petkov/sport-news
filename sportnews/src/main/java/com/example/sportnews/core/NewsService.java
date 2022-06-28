package com.example.sportnews.core;

import com.example.sportnews.core.models.News;
import com.example.sportnews.repositories.NewsRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NewsService {

    private final NewsRepository repository;

    public NewsService(NewsRepository repository) {
        this.repository = repository;
    }


    public News getNews(Integer id) {
        return Mappers.fromNewsDAO(repository.getNews(id));
    }


    public List<News> listNews(int page, int pageSize) {
        return repository.listNews(page, pageSize)
                .stream()
                .map(Mappers::fromNewsDAO)
                .collect(Collectors.toList());
    }
    public List<News> listNewsByCategory(String category,int page, int pageSize){
        return repository.listNewsByCategory(page, pageSize,category)
                .stream()
                .map(Mappers::fromNewsDAO)
                .collect(Collectors.toList());
    }

    public News createNews(String title, String content, String category, Integer user_id, String image_url) {
        return Mappers.fromNewsDAO(
                repository.createNews(title,content,category,user_id,image_url));
    }

    public void deleteNews(Integer id) {
        repository.deleteNews(id);
    }
}
