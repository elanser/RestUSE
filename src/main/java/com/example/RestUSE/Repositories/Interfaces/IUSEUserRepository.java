package com.example.RestUSE.Repositories.Interfaces;

import com.example.RestUSE.Entity.TUser;

import java.util.List;
import java.util.Optional;

public interface IUSEUserRepository {
    TUser getUserByLogin(String login);
    TUser getUserById(Long id);
    TUser getUserByLoginPassword(String login, String password);
    List<TUser> getUsers();
    Boolean isUser(String login);
}
