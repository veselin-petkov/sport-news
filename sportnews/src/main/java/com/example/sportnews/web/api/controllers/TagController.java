package com.example.sportnews.web.api.controllers;

import com.example.sportnews.core.TagService;
import com.example.sportnews.core.models.Tag;
import com.example.sportnews.web.api.models.NewsInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.sportnews.web.api.controllers.TokenUtil.getRoleFromToken;
import static com.example.sportnews.web.api.controllers.TokenUtil.getUserFromToken;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/tag")
@Controller
public class TagController {
    @Autowired
    public TagService tagService;

    @GetMapping("/{id}")
    public Tag getTag(@PathVariable Integer id){
        return tagService.getTag(id);
    }

    @GetMapping("/list")
    public List<Tag> listTags(){
        return tagService.listTags(0,20);
    }

    @PostMapping("/add")
    public Tag createTag(@RequestBody Tag tag, @RequestHeader("Authorization") String token){
        int roleID = getRoleFromToken(token);
        if (roleID==2) {
            return tagService.saveTag(tag.tag_name);
        }
        else {
            throw new AccessDeniedException("403");
        }
    }

    @DeleteMapping("/delete")
    public void deleteTag(@PathVariable Integer id){
        tagService.deleteTag(id);
    }

}
