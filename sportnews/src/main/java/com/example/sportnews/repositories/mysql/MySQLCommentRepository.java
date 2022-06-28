package com.example.sportnews.repositories.mysql;

import com.example.sportnews.repositories.CommentRepository;
import com.example.sportnews.repositories.models.CommentDAO;
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

public class MySQLCommentRepository implements CommentRepository {


    private final TransactionTemplate txTemplate;
    private final JdbcTemplate jdbc;

    public MySQLCommentRepository(TransactionTemplate txTemplate, JdbcTemplate jdbc) {
        this.txTemplate = txTemplate;
        this.jdbc = jdbc;
    }

    private CommentDAO fromResultSet(ResultSet rs) throws SQLException {
        return new CommentDAO(
                rs.getInt("id"),
                rs.getInt("user_id"),
                rs.getString("content"),
                rs.getTimestamp("date"),
                rs.getInt("news_id")
        );
    }

    @Override
    public List<CommentDAO> find(Integer id) {

        return jdbc.query(LIST_COMMENTS_FOR_POST,
                (rs, rowNum) -> fromResultSet(rs),id);
    }
    @Override
    public CommentDAO getComment(Integer id) {
        return jdbc.queryForObject(GET_COMMENT,
                (rs, rowNum) -> fromResultSet(rs), id);
    }

    @Override
    public List<CommentDAO> listComments(int page, int pageSize) {

        return jdbc.query(LIST_COMMENTS,
                (rs, rowNum) -> fromResultSet(rs), page*pageSize, pageSize);
    }

    @Override
    public CommentDAO crateComment(Integer user_id, String content, Integer news_id) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    INSERT_COMMENT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, user_id);
            ps.setString(2, content);
            ps.setInt(3, news_id);
            return ps;
        }, keyHolder);
        Integer id = Objects.requireNonNull(keyHolder.getKey()).intValue();
        return new CommentDAO(id,user_id,content,null,news_id);
    }

    @Override
    public void deleteComment(Integer id) {
        txTemplate.execute(status -> jdbc.update("DELETE FROM comments WHERE id = ?", id));
    }
    private static final String GET_COMMENT = ""+
            "SELECT \n" +
            "    c.id,\n" +
            "    c.user_id\n" +
            "    c.content,\n" +
            "    c.date,\n"+
            "    c.news_id,\n"+
            "FROM\n" +
            "    Comments c\n" +
            "WHERE c.news_id = ?";

    private static final String LIST_COMMENTS = "SELECT * from comments \n"+
            "LIMIT ?, ?";
    private static final String LIST_COMMENTS_FOR_POST = "SELECT * from comments \n"+
            "WHERE news_id = ?";

    private static final String INSERT_COMMENT =
            "INSERT INTO comments (user_id,content,news_id) VALUES (?,?,?)";


}
