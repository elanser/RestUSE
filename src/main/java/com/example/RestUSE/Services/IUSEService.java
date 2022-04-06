package com.example.RestUSE.Services;

import com.example.RestUSE.Entity.User;
import java.util.List;

public interface IUSEService {
    User getUserByLogin(String login);
    User getUser();
    List<User> getUsers();
}
