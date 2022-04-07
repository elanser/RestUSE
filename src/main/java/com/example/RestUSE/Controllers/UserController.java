package com.example.RestUSE.Controllers;

import com.example.RestUSE.Entity.User;
import com.example.RestUSE.Services.Interfaces.IUSEUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    IUSEUserService userService;

    @Autowired
    public void setInjectedBean(IUSEUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String helloWorld() {
        return "Справочник ЕГЭ по Python";
    }

    @RequestMapping("/user/{login}")
    public User getUser(@PathVariable String login) {
        return userService.getUserByLogin(login);
    }

    @RequestMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

}
