package com.example.sportnews.repositories.mysql;

import com.example.sportnews.repositories.TagToNewsRepository;
import com.example.sportnews.repositories.models.TagToNewsDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MySQLTagToNewsRepository implements TagToNewsRepository {


    private final TransactionTemplate txTemplate;
    private final JdbcTemplate jdbc;

    public MySQLTagToNewsRepository(TransactionTemplate txTemplate, JdbcTemplate jdbc) {
        this.txTemplate = txTemplate;
        this.jdbc = jdbc;

    }

    private TagToNewsDAO fromResultSet(ResultSet rs) throws SQLException {
        return new TagToNewsDAO(
                rs.getInt("news_id"),
                rs.getInt("tag_id"));
    }

    private TagToNewsDAO fromResultSetTagName(ResultSet rs) throws SQLException {

        return new TagToNewsDAO(
                rs.getInt("news_id"),
                rs.getInt("tag_id"),
                rs.getString("tag_name"));
    }
    @Override
    public TagToNewsDAO crateNewsToTags(Integer news_id, Integer tag_id) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    INSERT_TAG_NEWS, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, news_id);
            ps.setInt(2, tag_id);
            return ps;
        }, keyHolder);
        return new TagToNewsDAO(news_id,tag_id);
    }

    @Override
    public List<TagToNewsDAO> listNewsToTags(int page, int pageSize) {
        return jdbc.query("SELECT * FROM tag_news_relationship \n",
                (rs, rowNum) -> fromResultSet(rs));
    }


    @Override
    public List<TagToNewsDAO> findByTagId(Integer id) {

        return jdbc.query("SELECT tn.news_id,tn.tag_id,tag_name FROM tag_news_relationship as tn\n" +
                        "JOIN tags on tn.tag_id=tags.id "+
                        "WHERE tag_id = " + id,
                (rs, rowNum) -> fromResultSetTagName(rs));
    }

    @Override
    public List<TagToNewsDAO> findByNewsId(Integer id) {
        return jdbc.query("SELECT tn.news_id,tn.tag_id,tag_name FROM tag_news_relationship as tn\n" +
                        "JOIN tags on tn.tag_id=tags.id "+
                        "WHERE news_id = " + id,
                (rs, rowNum) -> fromResultSetTagName(rs));
    }

    @Override
    public void deleteByTagId(Integer id) {
        txTemplate.execute(status -> jdbc.update("DELETE FROM tag_news_relationship WHERE tag_id = ?", id));
    }

    @Override
    public void deleteByNewsId(Integer id){
        txTemplate.execute(status -> jdbc.update("DELETE FROM tag_news_relationship WHERE news_id = ?", id));
    }


    public static final String INSERT_TAG_NEWS=
            "INSERT INTO tag_news_relationship (news_id, tag_id) VALUES (?, ?)";


}
