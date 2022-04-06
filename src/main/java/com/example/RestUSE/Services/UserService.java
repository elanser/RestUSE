package com.example.RestUSE.Services;

import com.example.RestUSE.Entity.User;
import com.example.RestUSE.Repositories.IUSERepository;
import com.example.RestUSE.RestUseApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUSEService{
    IUSERepository userRepository;

    @Autowired
    public void setInjectedBean(IUSERepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByLogin(String login) {

        User result = null;
        for (User u:userRepository.getUsers()) {
            if (u.getUserLogin().equals(login)) {
                result = u;
                break;
            }
        }
        Optional<User> optional = Optional.ofNullable(result);
        return optional.orElse(new User("noUser","noPassword"));
    }

    @Override
    public User getUser() {
        Optional<User> optional = Optional.ofNullable(userRepository.getUsers().get(0));
        return optional.orElse(new User("noUser","noPassword"));
    }

    @Override
    public List<User> getUsers() {
        Optional<List<User>> optionalUsers = Optional.ofNullable(userRepository.getUsers());
        return optionalUsers.orElse(new ArrayList<>());
    }
}