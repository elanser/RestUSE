package com.example.RestUSE.Repositories;

import com.example.RestUSE.Entity.User;
import com.example.RestUSE.Repositories.Interfaces.IUSEUserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserArrayRepository implements IUSEUserRepository {
    @Override
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User("elanser","123qwe"));
        list.add(new User("ivan","qwerty"));
        list.add(new User("a.s.eldarov","miumiu"));
        return list;
    }
}
