package com.example.sportnews.web.api.controllers;

import com.example.sportnews.core.NewsService;

import com.example.sportnews.core.models.News;
import com.example.sportnews.web.api.models.NewsInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static com.example.sportnews.web.api.controllers.TokenUtil.getRoleFromToken;
import static com.example.sportnews.web.api.controllers.TokenUtil.getUserFromToken;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/news")
@Controller
public class NewsController {

    public NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("")
    public List<News> list() {
        return newsService.listNews(0,15);
    }


    @GetMapping("/{id}")
    public ResponseEntity<News> get(@PathVariable Integer id) {
        try {
            News news = newsService.getNews(id);
            return new ResponseEntity<News>(news, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<News>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/category/{category}")
    public List<News> listNewsByCategory(@PathVariable String category){
        return newsService.listNewsByCategory(category,0,20);
    }

    @PostMapping("/add")
    public void add(@RequestBody NewsInput newsInput, @RequestHeader("Authorization") String token) {
        int roleID = getRoleFromToken(token);
        int userID = getUserFromToken(token);
        if (roleID==2){
            newsService.createNews(newsInput.title,newsInput.content,newsInput.category,userID,newsInput.image_url);
        } else {
            throw new AccessDeniedException("403");
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        newsService.deleteNews(id);
    }
}
