package com.example.RestUSE.security.jwt;

import com.example.RestUSE.Entity.Role;
import com.example.RestUSE.Entity.User;
import com.example.RestUSE.Repositories.Interfaces.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    @Autowired
    private static RoleRepository roleRepository;

    public JwtUserFactory() {

    }

    public static JwtUser create(User user) {
        return new JwtUser(

                user.getId(),
                user.getMail(),
                user.getLogin(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                Date.from(Instant.now()),
                true,
                Date.from(Instant.now()),
                fromRoles(new ArrayList<>(user.getRoles()))
        );
    }

    private static List<GrantedAuthority> fromRoles (List<Role> roles) {
        if (roles !=null ) {
            return roles.stream()
                    .map(role-> new SimpleGrantedAuthority(role.getNamerole()))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
