package com.example.sportnews.core;

import com.example.sportnews.core.models.Tag;
import com.example.sportnews.repositories.TagRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag getTag(Integer id){
         return Mappers.fromTagDao(tagRepository.getTag(id));
    }

    public List<Tag> listTags(int page, int pageSize){
        return tagRepository.listTags(page,pageSize)
                .stream()
                .map(Mappers::fromTagDao)
                .collect(Collectors.toList());
    }

    public Tag saveTag(String tag_name){
        return Mappers.fromTagDao(tagRepository.createTag(tag_name));
    }

    public void deleteTag(Integer id){
        tagRepository.deleteTag(id);
    }
}
