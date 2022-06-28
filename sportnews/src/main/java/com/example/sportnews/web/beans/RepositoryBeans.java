package com.example.sportnews.web.beans;



import com.example.sportnews.repositories.*;
import com.example.sportnews.repositories.mysql.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
public class RepositoryBeans {
    @Bean
    public UserRepository userRepository(TransactionTemplate txTemplate, JdbcTemplate jdbcTemplate) {
        return new MySQLUserRepository(txTemplate, jdbcTemplate);
    }

    @Bean
    public NewsRepository newsRepository(TransactionTemplate txTemplate, JdbcTemplate jdbcTemplate) {
        return new MySQLNewsRepository(txTemplate, jdbcTemplate);
    }

    @Bean
    public CommentRepository commentRepository(TransactionTemplate txTemplate, JdbcTemplate jdbcTemplate) {
        return new MySQLCommentRepository(txTemplate, jdbcTemplate);
    }

    @Bean
    public TagToNewsRepository tagToNewsRepository(TransactionTemplate txTemplate, JdbcTemplate jdbcTemplate) {
        return new MySQLTagToNewsRepository(txTemplate, jdbcTemplate);
    }

    @Bean
    public TagRepository tagRepository(TransactionTemplate txTemplate, JdbcTemplate jdbcTemplate) {
        return new MySQLTagRepository(txTemplate, jdbcTemplate);
    }

    @Bean
    public CategoryRepository categoryRepository(TransactionTemplate txTemplate, JdbcTemplate jdbcTemplate) {
        return new MySQLCategoryRepository(txTemplate, jdbcTemplate);
    }
}
