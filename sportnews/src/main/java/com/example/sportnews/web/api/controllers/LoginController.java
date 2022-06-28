package com.example.sportnews.web.api.controllers;

import com.example.sportnews.core.MyUserDetailsService;
import com.example.sportnews.core.MyUserSec;
import com.example.sportnews.core.UserService;
import com.example.sportnews.core.models.AuthenticationRequest;
import com.example.sportnews.core.models.AuthenticationResponse;
import com.example.sportnews.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws  Exception{


        String passwordHash = userService.authorizeUser(authenticationRequest.getUsername(),authenticationRequest.getPassword());


        System.out.println(passwordHash);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),passwordHash)
            );
        } catch (BadCredentialsException e ){
            throw new Exception("Incorrect username or password", e);
        }

        final MyUserSec userDetails = (MyUserSec) userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
