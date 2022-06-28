package com.example.sportnews.core;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class MyUserSec extends User {
    private Integer id;
    private Integer role;


    public MyUserSec(String username, String password, Integer id,Integer role, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
        this.role = role;
    }

    public MyUserSec(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public Integer getId() {
        return id;
    }

    public MyUserSec setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getRole() {
        return role;
    }

    public MyUserSec setRole(Integer role) {
        this.role = role;
        return this;
    }
}