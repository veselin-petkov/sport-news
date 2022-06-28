package com.example.sportnews.repositories;


import com.example.sportnews.repositories.models.UserDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    UserDAO createUser(String username, String password, String email, String salt);
    UserDAO getUser(int id);
    UserDAO getUserByUsername(String username);
    List<UserDAO> listUsers(int page, int pageSize);
    void deleteUser(int id);
}
