package com.example.sportnews.core.models;

import com.example.sportnews.core.UserService;
import com.example.sportnews.repositories.UserRepository;
import com.example.sportnews.repositories.models.UserDAO;
import com.example.sportnews.web.api.controllers.UserController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    private UserController userController;
    private UserRepository userRepository;
    private UserService userService;
    private static final String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGUiOjIsImlkIjoxLCJleHAiOjE2NTU2MDQwNjEsImlhdCI6MTY1NTU2ODA2MX0.P_rLyMrxrXooLwMDVZySJ47xstD9f_DiK4RL5v5Pd-U";


    @BeforeEach
    public void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userController = new UserController(new UserService(userRepository));
        userService = new UserService(userRepository);
    }

    @Test
    public void getUserTest() {
        UserDAO userDAO = new UserDAO(1, "user", "psd", "user@abv.com", null, null, "123");

        ResponseEntity<User> response = userController.get(anyInt());

        Assertions.assertEquals(userDAO.id, Objects.requireNonNull(response.getBody()).id);
        Assertions.assertEquals(userDAO.username, response.getBody().username);
        Assertions.assertEquals(userDAO.email, response.getBody().email);
    }



    @Test
    public void listUsersTest() {
        UserDAO userDAO = new UserDAO(1, "user", "psd", "user@abv.com",  null,  null, "123");
        List<UserDAO> users = new ArrayList<>();
        users.add(userDAO);
        when(userRepository.listUsers(0,50)).thenReturn(users);


        List<User> response = userController.list();


        assertEquals(users.size(), response.size());
        for (int i = 0; i < users.size(); i++) {
            assertEquals(users.get(i).id, response.get(i).id);
            assertEquals((users.get(i).username), response.get(i).username);
        }
    }

}
