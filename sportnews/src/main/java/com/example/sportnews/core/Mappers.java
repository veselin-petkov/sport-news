package com.example.sportnews.core;

import com.example.sportnews.core.models.*;
import com.example.sportnews.repositories.models.*;

public class Mappers {
    public static User fromUsersDAO(UserDAO user){
        return new User(user.id, user.username, user.password, user.email, user.registration_date, user.role_id, user.salt);
    }

    public static News fromNewsDAO(NewsDAO news){
        return new News(news.id, news.title, news.content, news.date, news.category, news.user_id, news.image_url);
    }

    public static Comment fromCommentDAO(CommentDAO comment){
        return new Comment(comment.id, comment.user_id, comment.content, comment.date, comment.news_id);
    }

    public static TagToNews fromTagToNewsDAO1(TagToNewsDAO newsToTagDAO){
        return new TagToNews(newsToTagDAO.news_id, newsToTagDAO.tag_id);
    }

    public static TagToNews fromTagToNewsDAO2(TagToNewsDAO newsToTagDAO){
        return new TagToNews(newsToTagDAO.news_id, newsToTagDAO.tag_id, newsToTagDAO.tag_name);
    }

    public static Tag fromTagDao(TagDAO tagDAO) {
        return new Tag(tagDAO.id,tagDAO.tag_name);
    }

    public static Category fromCategoryDAO (CategoryDAO categoryDAO){
        return  new Category(categoryDAO.category);
    }

}
