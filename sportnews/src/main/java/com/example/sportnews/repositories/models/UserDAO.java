package com.example.sportnews.repositories.models;

import java.sql.Timestamp;

public class UserDAO {
    public final Integer id;
    public final String username;
    public final String password;
    public final String email;
    public final Timestamp registration_date;
    public final Integer role_id;
    public final String salt;


    public UserDAO(Integer id, String username, String password, String email, Timestamp registration_date, Integer role_id, String salt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.registration_date = registration_date;
        this.role_id = role_id;
        this.salt = salt;
    }


}