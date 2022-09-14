package com.example.RestUSE.Services;

import com.example.RestUSE.Entity.User;
import com.example.RestUSE.Repositories.Interfaces.UserRepository;
import com.example.RestUSE.Services.Interfaces.IUserService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@Service
public class UserService implements IUserService {
    UserRepository userRepositoryJPA;

    public UserService(UserRepository userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    @Override
    public User getUserById(Long iD) {
        return userRepositoryJPA.getUserById(iD).orElse(new User());
    }

    @Override
    public  CompletableFuture<List<User>> getUsersJPA() {
        Supplier<List<User>> supplierUsers =
                () -> userRepositoryJPA.getUsersJPA().orElse(new ArrayList<>());
        CompletableFuture<List<User>> cfUsers = CompletableFuture.supplyAsync(supplierUsers);
        return cfUsers;
    }

    @Override
    public Boolean isUser(String login) {
        return userRepositoryJPA.isUser(login).isPresent();
    }

    @Override
    public User getUserByLoginPassword(String login, String password) {
        return null;
    }

    @Override
    public User getUserByLoginPasswordJPA(String login, String password) {
        return userRepositoryJPA.findByLoginAndPassword(login,password).orElse(new User());
    }

    @Override
    public CompletableFuture<User> getUserByLoginPasswordJPAQuery(String login, String password) {
        Supplier<User> supplierUser =
                () -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return userRepositoryJPA.queryUserByLoginPassword(login,password).orElse(new User());
        };
        CompletableFuture<User> cfUser =
                CompletableFuture.supplyAsync(supplierUser);
        return cfUser;
    }

}
