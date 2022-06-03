package com.example.RestUSE.Services;

import com.example.RestUSE.Entity.User;
import com.example.RestUSE.Repositories.Interfaces.IUSEUserRepository;
import com.example.RestUSE.Repositories.Interfaces.UserRepository;
import com.example.RestUSE.Services.Interfaces.IUSEUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUSEUserService {
    IUSEUserRepository userRepository;
    UserRepository userRepositoryJPA;

    public UserService(IUSEUserRepository userRepository, UserRepository userRepositoryJPA) {
        this.userRepository = userRepository;
        this.userRepositoryJPA = userRepositoryJPA;
    }


    @Override
    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public List<User> getUsersJPA() {
        return userRepositoryJPA.getUsersJPA().orElse(new ArrayList<>());
    }

    @Override
    public Boolean isUser(String login) {
        return userRepository.isUser(login);
    }

    @Override
    public User getUserByLoginPassword(String login, String password) {
        return userRepository.getUserByLoginPassword(login,password);
    }
    @Override
    public Optional<User> getUserByLoginPasswordJPA(String login, String password) {
        return userRepositoryJPA.findByLoginAndPassword(login,password);
    }

    @Override
    public Optional<User> getUserByLoginPasswordJPAQuery(String login, String password) {
        return userRepositoryJPA.queryByLoginPassword(login,password);
    }

    //queryByLoginPassword

}
