package com.example.sportnews.core;

import com.example.sportnews.core.models.Comment;
import com.example.sportnews.repositories.CommentRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> listComments(int page, int pageSize) {
        return commentRepository.listComments(page, pageSize)
                .stream()
                .map(Mappers::fromCommentDAO)
                .collect(Collectors.toList());
    }

    public Comment getComment(Integer id){
        return Mappers.fromCommentDAO(commentRepository.getComment(id));
    }

    public Comment createComment(String content,Integer user_id,Integer news_id){
      return Mappers.fromCommentDAO(commentRepository.crateComment(user_id,content,news_id));
    }

    public void deleteComment(Integer id){
        commentRepository.deleteComment(id);
    }

    public List<Comment> find(Integer id){
        return commentRepository.find(id)
                .stream()
                .map(Mappers::fromCommentDAO)
                .collect(Collectors.toList());
    }
}
