package com.example.RestUSE.Services;

import com.example.RestUSE.Entity.TUser;
import com.example.RestUSE.Repositories.Interfaces.IUSEUserRepository;
import com.example.RestUSE.Services.Interfaces.IUSEUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUSEUserService {
    IUSEUserRepository userRepository;

    @Autowired
    public void setInjectedBean(IUSEUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public TUser getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Override
    public TUser getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<TUser> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public Boolean isUser(String login) {
        return userRepository.isUser(login);
    }

    @Override
    public TUser getUserByLoginPassword(String login, String password) {
        return userRepository.getUserByLoginPassword(login,password);
    }

}
