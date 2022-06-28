package com.example.sportnews.web.api.controllers;


import com.example.sportnews.core.TagToNewsService;
import com.example.sportnews.core.models.TagToNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.sportnews.web.api.controllers.TokenUtil.getRoleFromToken;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/tagtonews")
@Controller
public class TagToNewsController {

    @Autowired
    public TagToNewsService tagToNewsService;

    public TagToNewsController(TagToNewsService tagToNewsService) {
        this.tagToNewsService = tagToNewsService;
    }

    @GetMapping("/tag/{id}")
    public List<TagToNews> listTagToNewsByTag(@PathVariable Integer id){
        return tagToNewsService.getTagToNewsByTag(id);
    }
    @GetMapping("/news/{id}")
    public List<TagToNews> listTagToNewsByPost(@PathVariable Integer id){
        return tagToNewsService.getTagToNewsByNews(id);
    }

    @PostMapping("/add")
    public TagToNews saveTag(@RequestBody TagToNews tagToNews,@RequestHeader("Authorization") String token){
        int roleID = getRoleFromToken(token);
        if (roleID==2) {
            return tagToNewsService.saveTagToNews(tagToNews.news_id, tagToNews.tag_id);
        }else {
            throw new AccessDeniedException("403");
        }
    }
    @DeleteMapping("/tag/{id}")
    public void deleteByTagId(Integer id){
        tagToNewsService.deleteTagToNewsByTag(id);
    }

    @DeleteMapping("/news/{id}")
    public void deleteByNewsId(Integer id){
        tagToNewsService.deleteTagToNewsByNews(id);
    }
}
