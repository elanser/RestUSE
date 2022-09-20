package com.example.RestUSE.Services.Interfaces;

import com.example.RestUSE.Dto.UserDto;
import com.example.RestUSE.Entity.User;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;


public interface IUserService {
    Optional<User> findByLogin(String login);
    UserDto getUserById(Long iD);
    List<UserDto> getUsersJPA();
    Boolean isUser(String login);
    UserDto getUserByLoginPassword(String login, String password);
    UserDto getUserByLoginPasswordJPA(String login, String password);
    UserDto getUserByLoginPasswordJPAQuery(String login, String password);
    UserDto registerUser(String login, String password, String email);
}
