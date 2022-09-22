package com.example.RestUSE.security;

import com.example.RestUSE.Entity.User;
import com.example.RestUSE.Services.UserService;
import com.example.RestUSE.security.jwt.JwtUser;
import com.example.RestUSE.security.jwt.JwtUserFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByLogin(username).orElse(null);
        if (user==null) {
            throw new UsernameNotFoundException("User "+ username + " not found!");
        }
        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN - loadUserByUsername, user: {} loaded",username);
        return jwtUser;
    }
}
