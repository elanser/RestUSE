package com.example.RestUSE.Services.Interfaces;

import com.example.RestUSE.Entity.User;
import java.util.List;

public interface IUSEUserService {
    User getUserByLogin(String login);
    User getUser();
    List<User> getUsers();
}
