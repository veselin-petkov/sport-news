package com.example.sportnews.core;


import com.example.sportnews.core.models.User;
import com.example.sportnews.repositories.UserRepository;
import com.example.sportnews.repositories.models.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDAO userDAO = userRepository.getUserByUsername(username);
        return new MyUserSec(userDAO.username,userDAO.password,userDAO.id,userDAO.role_id,new ArrayList<>());

    }


}
