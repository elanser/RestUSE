package com.example.RestUSE.Controllers;

import com.example.RestUSE.Entity.User;
import com.example.RestUSE.Services.Interfaces.IUSEUserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    IUSEUserService userService;


    public UserController(IUSEUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User getUser(@RequestParam("login") String login, @RequestParam("password") String password) {
        return userService.getUserByLoginPassword(login,password);
    }

    @RequestMapping(value = "/loginPass",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    User getUserJPA(@RequestParam("login") String login, @RequestParam("password") String password) {
        return userService.getUserByLoginPasswordJPAQuery(login,password).orElse(new User());
    }

    @RequestMapping(value = "/id/{id}", produces = "application/json", method = {RequestMethod.GET, RequestMethod.PUT})
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping("/all")
    public List<User> getUsers() {
        return userService.getUsersJPA();
    }

    @RequestMapping(value = "/is/{login}", produces = "application/json", method = {RequestMethod.GET, RequestMethod.PUT})
    public Boolean isUser(@PathVariable String login) {
        return userService.isUser(login);
    }

}
