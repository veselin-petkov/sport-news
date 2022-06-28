package com.example.sportnews.repositories;

import com.example.sportnews.repositories.models.CommentDAO;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CommentRepository {
    List<CommentDAO> find(Integer id);

    CommentDAO getComment(Integer id);

    CommentDAO crateComment(Integer user_id, String content, Integer news_id);

    void deleteComment(Integer id);

    List<CommentDAO> listComments(int page, int pageSize);

}
