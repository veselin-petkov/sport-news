package com.example.sportnews.core.models;

import java.sql.Timestamp;

public class User {

    public final Integer id;
    public final String username;
    public final String password;
    public final String email;
    public final Timestamp registration_date;
    public final Integer role_id;
    public final String salt;

    public User(Integer id, String username, String password, String email, Timestamp registration_date, Integer role_id, String salt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.registration_date = registration_date;
        this.role_id = role_id;
        this.salt = salt;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", registration_date'" + registration_date +'\''+
                ", role_id=" + role_id +
                '}';
    }

}
