package com.example.sportnews.web.api.controllers;

import com.example.sportnews.core.CommentService;
import com.example.sportnews.core.models.Comment;
import com.example.sportnews.web.api.models.CommentInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.sportnews.web.api.controllers.TokenUtil.getUserFromToken;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/news/comments")
@Controller
public class CommentController {

    @Autowired
    public CommentService commentService;


    @GetMapping("")
    public List<Comment> list(){
        return commentService.listComments(0,20);
    }

    @GetMapping("/{id}")
    public List<Comment> find(@PathVariable Integer id){

        return commentService.find(id);
    }

    @PostMapping("/add/{news_id}")
    public void addComment(@RequestBody CommentInput commentInput,
                              @RequestHeader("Authorization") String token,@PathVariable Integer news_id){
        int userID = getUserFromToken(token);
       commentService.createComment(commentInput.content,userID,news_id);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);
    }

}
