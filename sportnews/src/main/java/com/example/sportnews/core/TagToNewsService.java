package com.example.sportnews.core;

import com.example.sportnews.core.models.TagToNews;
import com.example.sportnews.repositories.TagToNewsRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagToNewsService {

    private final TagToNewsRepository tagToNewsRepository;


    public TagToNewsService(TagToNewsRepository tagToNewsRepository) {
        this.tagToNewsRepository = tagToNewsRepository;
    }


    public List<TagToNews> listAllTagToPosts(int page, int pageSize) {
        return tagToNewsRepository.listNewsToTags(page, pageSize)
                .stream()
                .map(Mappers::fromTagToNewsDAO1)
                .collect(Collectors.toList());
    }

    public TagToNews saveTagToNews(Integer news_id, Integer tag_id) {
        return Mappers.fromTagToNewsDAO1(
                tagToNewsRepository.crateNewsToTags(news_id,tag_id));
    }

    public List<TagToNews> getTagToNewsByTag(Integer id) {
        return tagToNewsRepository.findByTagId(id)
                .stream()
                .map(Mappers::fromTagToNewsDAO2)
                .collect(Collectors.toList());
    }

    public List<TagToNews> getTagToNewsByNews(Integer id) {
        return tagToNewsRepository.findByNewsId(id)
                .stream()
                .map(Mappers::fromTagToNewsDAO2)
                .collect(Collectors.toList());
    }

    public void deleteTagToNewsByTag(Integer id) {
        tagToNewsRepository.deleteByTagId(id);
    }

    public void deleteTagToNewsByNews(Integer id) {
        tagToNewsRepository.deleteByNewsId(id);
    }

}
