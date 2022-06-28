package com.example.sportnews.repositories.mysql;

import com.example.sportnews.repositories.NewsRepository;

import com.example.sportnews.repositories.models.NewsDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

public class MySQLNewsRepository implements NewsRepository {


    private final TransactionTemplate txTemplate;
    private final JdbcTemplate jdbc;

    public MySQLNewsRepository(TransactionTemplate txTemplate, JdbcTemplate connection) {
        this.txTemplate = txTemplate;
        this.jdbc = connection;
    }


    private NewsDAO fromResultSet(ResultSet rs) throws SQLException {
        return new NewsDAO(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("content"),
                rs.getTimestamp("date"),
                rs.getString("category"),
                rs.getInt("user_id"),
                rs.getString("image_url"));
    }
    @Override
    public NewsDAO createNews(String title, String content, String category, Integer user_id, String image_url) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    INSERT_NEWS, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setString(3, category);
            ps.setInt(4, user_id);
            ps.setString(5,image_url);
            return ps;
        }, keyHolder);

        Integer id = Objects.requireNonNull(keyHolder.getKey()).intValue();
        return new NewsDAO(id, title, content,null,category, user_id, image_url);

    }

    @Override
    public NewsDAO getNews(Integer id) {
        return jdbc.queryForObject(GET_NEWS,
                (rs, rowNum) -> fromResultSet(rs), id);
    }

    @Override
    public List<NewsDAO> listNews(Integer page, Integer pageSize) {
        return jdbc.query(LIST_NEWS,
                (rs, rowNum) -> fromResultSet(rs), page*pageSize, pageSize);
    }

    @Override
    public List<NewsDAO> listNewsByCategory(Integer page, Integer pageSize, String category) {
        return jdbc.query(LIST_NEWS_BY_CATEGORY,
                (rs, rowNum) -> fromResultSet(rs), category,page*pageSize, pageSize);
    }
    @Override
    public List<NewsDAO> listNewsByTag(Integer page, Integer pageSize, String category) {
        return jdbc.query(LIST_NEWS_BY_CATEGORY,
                (rs, rowNum) -> fromResultSet(rs), category,page*pageSize, pageSize);
    }
    @Override
    public void deleteNews(int id) {
        txTemplate.execute(status -> jdbc.update(DELETE_NEWS, id));
    }

    public static final String GET_NEWS = "" +
            "SELECT *\n" +
            "FROM\n" +
            "    News n\n" +
            "WHERE n.id = ?";
    public static final String LIST_NEWS = "" +
            "SELECT * \n" +
            "FROM\n" +
            "    News n\n" +
            "LIMIT ?, ?";


    public static final String DELETE_NEWS = "DELETE FROM News WHERE id = ?";


    public static final String INSERT_NEWS =
            "INSERT INTO News (title, content,category, user_id, image_url) VALUES (?, ?, ?, ? ,?)";

    private static final String LIST_NEWS_BY_CATEGORY =  "" +
            "SELECT * \n" +
            "FROM\n" +
            "    News n\n" +
            "    WHERE category=?"+
            "LIMIT ?, ?";

    private static final String LIST_NEWS_BY_TAG =  "" +
            "SELECT * \n" +
            "FROM\n" +
            "    News n\n" +
            "    WHERE category=?"+
            "LIMIT ?, ?";


}
