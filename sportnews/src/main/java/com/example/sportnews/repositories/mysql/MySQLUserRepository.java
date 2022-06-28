package com.example.sportnews.repositories.mysql;

import com.example.sportnews.repositories.UserRepository;
import com.example.sportnews.repositories.models.UserDAO;
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


public class MySQLUserRepository implements UserRepository {
    private final TransactionTemplate txTemplate;
    private final JdbcTemplate jdbc;


    public MySQLUserRepository(TransactionTemplate txTemplate, JdbcTemplate connection) {
        this.txTemplate = txTemplate;
        this.jdbc = connection;
    }

    @Override
    public UserDAO createUser(String username, String password, String email, String salt) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, salt);
            return ps;
        }, keyHolder);

        Integer id = Objects.requireNonNull(keyHolder.getKey()).intValue();
        return new UserDAO(id, username, password, email,null, 1, salt);
    }

    @Override
    public List<UserDAO> listUsers(int page, int pageSize) {
        return jdbc.query(LIST_USERS,
                (rs, rowNum) -> fromResultSet(rs), page * pageSize, pageSize);
    }

    @Override
    public UserDAO getUser(int id) {
        return jdbc.queryForObject(GET_USER,
                (rs, rowNum) -> fromResultSet(rs), id);
    }

    @Override
    public UserDAO getUserByUsername(String username) {
        return jdbc.queryForObject(GET_USER_BY_USERNAME,
                (rs, rowNum) -> fromResultSet(rs), username);
    }

    @Override
    public void deleteUser(int id) {
        txTemplate.execute(status -> jdbc.update(DELETE_USER, id));
    }

    private UserDAO fromResultSet(ResultSet rs) throws SQLException {
        return new UserDAO(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getTimestamp("registration_date"),
                rs.getInt("role_id"),
                rs.getString("salt"));
    }

    public static final String INSERT_USER =
            "INSERT INTO Users (username, password,email,salt) VALUES (?, ?, ?, ?)";
    public static final String GET_USER = "" +
            "SELECT \n" +
            "    u.id,\n" +
            "    u.password,\n" +
            "    u.username,\n" +
            "    u.email,\n" +
            "    u.registration_date,\n" +
            "    u.role_id,\n" +
            "    u.salt\n"+
            "FROM\n" +
            "    Users u\n" +
            "WHERE u.id = ?";


    public static final String GET_USER_BY_USERNAME = "" +
            "SELECT \n" +
            "    u.id,\n" +
            "    u.password,\n" +
            "    u.username,\n" +
            "    u.email,\n" +
            "    u.registration_date,\n" +
            "    u.role_id,\n" +
            "    u.salt\n"+
            "FROM\n" +
            "    Users u\n" +
            "WHERE u.username = ?";
    public static final String LIST_USERS = "" +
            "SELECT \n" +
            "    u.id,\n" +
            "u.password,\n" +
            "    u.username,\n" +
            "    u.email,\n" +
            "u.registration_date,\n" +
            "    u.role_id,\n" +
            "    u.salt\n"+
            "FROM\n" +
            "    Users u\n" +
            "LIMIT ?, ?";

    public static final String DELETE_USER = "DELETE FROM Users WHERE id = ?";

}
