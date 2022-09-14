package com.example.RestUSE.Services.Interfaces;

import com.example.RestUSE.Entity.User;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public interface IUserService {
    User getUserById(Long iD);
    CompletableFuture<List<User>> getUsersJPA();
    Boolean isUser(String login);
    User getUserByLoginPassword(String login, String password);
    User getUserByLoginPasswordJPA(String login, String password);
    CompletableFuture<User> getUserByLoginPasswordJPAQuery(String login, String password);
}