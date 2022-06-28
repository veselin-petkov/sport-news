package com.example.sportnews.repositories.mysql;

import com.example.sportnews.repositories.CategoryRepository;
import com.example.sportnews.repositories.models.CategoryDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MySQLCategoryRepository implements CategoryRepository {

    private final TransactionTemplate txTemplate;
    private final JdbcTemplate jdbc;

    public MySQLCategoryRepository(TransactionTemplate txTemplate, JdbcTemplate jdbc) {
        this.txTemplate = txTemplate;
        this.jdbc = jdbc;
    }
    private CategoryDAO fromResultSet(ResultSet rs) throws SQLException {
        return new CategoryDAO(
                rs.getString("category")
        );}

    @Override
    public CategoryDAO getCategory(String category) {

        return jdbc.queryForObject("SELECT * FROM categories WHERE category = ?",
                (rs, rowNum) -> fromResultSet(rs),category);
    }


    @Override
    public List<CategoryDAO> listCategories(int page, int pageSize) {
    return jdbc.query("SELECT * FROM categories LIMIT ?,?",
                (rs, rowNum) -> fromResultSet(rs), page*pageSize, pageSize);
    }


    @Override
    public CategoryDAO crateCategory(String category) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO categories (category) VALUES (?);", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, category);
            return ps;
        }, keyHolder);
        return new CategoryDAO(category);
    }

    @Override
    public void deleteCategory(String category) {

        txTemplate.execute(status -> jdbc.update("DELETE FROM categories WHERE category = ?", category));

    }

}
