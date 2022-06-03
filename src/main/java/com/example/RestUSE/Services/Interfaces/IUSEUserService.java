package com.example.RestUSE.Services.Interfaces;

import com.example.RestUSE.Entity.User;

import java.util.List;
import java.util.Optional;

public interface IUSEUserService {
    User getUserByLogin(String login);
    User getUserById(Long iD);
    List<User> getUsers();
    List<User> getUsersJPA();
    Boolean isUser(String login);
    User getUserByLoginPassword(String login, String password);
    Optional<User> getUserByLoginPasswordJPA(String login, String password);
    Optional<User> getUserByLoginPasswordJPAQuery(String login, String password);
}
