package com.example.RestUSE.Controllers;

import com.example.RestUSE.Entity.User;
import com.example.RestUSE.Services.Interfaces.IUserService;
import com.example.RestUSE.auth.Authenticator;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    IUserService userService;


    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/loginPass", produces = "application/json")
    public @ResponseBody
    CompletableFuture<User> getUserJPA(@RequestParam("login") String login,
                    @RequestParam("password") String password) throws ExecutionException, InterruptedException {
        return userService.getUserByLoginPasswordJPAQuery(login,password);
    }

    @RequestMapping(value = "/id/{id}", produces = "application/json", method = {RequestMethod.GET, RequestMethod.PUT})
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    @RequestMapping(value ="/all", produces = "application/json")
    public CompletableFuture<List<User>> getUsers() {
        return userService.getUsersJPA();
    }

    @RequestMapping(value = "/is/{login}", produces = "application/json", method = {RequestMethod.GET, RequestMethod.PUT})
    public Boolean isUser(@PathVariable String login) {
        return userService.isUser(login);
    }


    @RequestMapping(value = "/login", produces = "application/json")
    public @ResponseBody
    CompletableFuture<String> loginUser(@RequestParam("login") String login,
                                           @RequestParam("password") String password)
            throws ExecutionException, InterruptedException, LoginException
    {
        Supplier<String> supplierUser = () -> {
            Authenticator auth = Authenticator.getInstance(userService);
            String auth_token = null;
            try {
                auth_token = auth.loginUser(login,password);
            } catch (LoginException e) {
                e.printStackTrace();
            }
            return auth_token;
        };
        CompletableFuture<String> cfAuthToken =
                CompletableFuture.supplyAsync(supplierUser);
        return cfAuthToken;
    }

}
