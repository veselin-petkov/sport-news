package com.example.sportnews.web.api.controllers;

import com.example.sportnews.core.UserService;

import com.example.sportnews.core.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/users")
@Controller
public class UserController {

    @Autowired
    public UserService userService;


    @GetMapping("")
    public List<User> list() {
        return userService.listUsers(0,50);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
            User user = userService.getUser(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/add")
    public void add(@RequestBody User user) {
        userService.createUser(user.username, user.password, user.email);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
