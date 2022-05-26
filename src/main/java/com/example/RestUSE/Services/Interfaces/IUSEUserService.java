package com.example.RestUSE.Services.Interfaces;

import com.example.RestUSE.Entity.TUser;
import java.util.List;

public interface IUSEUserService {
    TUser getUserByLogin(String login);
    TUser getUserById(Long iD);
    List<TUser> getUsers();
    Boolean isUser(String login);
    TUser getUserByLoginPassword(String login, String password);

}
