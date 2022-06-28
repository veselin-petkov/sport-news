package com.example.sportnews.repositories.mysql;

import com.example.sportnews.repositories.TagRepository;
import com.example.sportnews.repositories.models.TagDAO;
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

public class MySQLTagRepository implements TagRepository {

    private final TransactionTemplate txTemplate;
    private final JdbcTemplate jdbc;

    public MySQLTagRepository(TransactionTemplate txTemplate, JdbcTemplate jdbc) {
        this.txTemplate = txTemplate;
        this.jdbc = jdbc;
    }

    private TagDAO fromResultSet(ResultSet rs) throws SQLException {
        return new TagDAO(
                rs.getInt("id"),
                rs.getString("tag_name")
        );
    }

    @Override
    public TagDAO createTag(String tag_name) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    INSERT_TAG, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tag_name);
            return ps;
        }, keyHolder);
        Integer id = Objects.requireNonNull(keyHolder.getKey()).intValue();
        return new TagDAO(id,tag_name);    }

    @Override
    public TagDAO getTag(Integer id) {
        return jdbc.queryForObject(GET_TAG,
                (rs, rowNum) -> fromResultSet(rs), id);
    }

    @Override
    public List<TagDAO> listTags(int page, int pageSize) {
        return jdbc.query("SELECT * FROM tags \n",
                (rs, rowNum) -> fromResultSet(rs));
    }

    @Override
    public void deleteTag(Integer id) {
        txTemplate.execute(status -> jdbc.update("DELETE FROM tags WHERE id = ?", id));
    }


    public static final String GET_TAG =
            "SELECT * FROM tags WHERE id = ?";
    public static final String INSERT_TAG =
            "INSERT INTO  tags (tag_name) VALUES (?)";
}
