package com.example.RestUSE.auth;

import com.example.RestUSE.Entity.User;
import com.example.RestUSE.Services.Interfaces.IUserService;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;
import java.security.GeneralSecurityException;
import java.sql.Timestamp;
import java.util.*;


@Component
public final class Authenticator {
    IUserService userService;

    private static Authenticator instance = null;

    // users (key:login, value user)
    private Map<String, User> usersMap;

    // tokens генерируются во время сессии, токен жив до логаута (key: login, value: token)
    private Map<String, String> loginToken;

    // tokens генерируются во время сессии, токен жив до логаута (key: token, value: login)
    private Map<String, String> tokenLogin;

    // Last Activity (key: token, value: lastActivity)
    private Map<String, Timestamp> lastActivityToken;


    public static Authenticator getInstance(IUserService userService) {
        if (instance == null) {
            instance = new Authenticator(userService);
        }
        return instance;
    }

    private Authenticator(IUserService userService) {
        this.userService = userService;
        usersMap = new HashMap<>();
        loginToken = new HashMap<>();
        tokenLogin = new HashMap<>();
        lastActivityToken = new HashMap<>();
        /*
        List<User> users = this.userRepositoryJPA.getUsersJPA().orElse(new ArrayList<>());
        usersStorage = users.stream().collect(Collectors.toMap(
           User::getLogin, User::getPassword
        ));
        */

    }
    private  Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public String loginUser(String login, String password) throws LoginException {
//        User user = null;
//        String authToken="";
//        Timestamp lastActivity  = getTimestamp();
//
//        if (usersMap.containsKey(login)) {
//            user = usersMap.get(login);
//        }
//        else {
//            // ищем в репозитории
//            user = userService.getUserByLoginPasswordJPA(login, password);
//        }
//        if (user.getLogin() != null) {
//            if (!usersMap.containsKey(login)) {
//                usersMap.put(login,user);
//            }
//            if (login.equals(user.getLogin())) {
//                if (!loginToken.containsKey(login)) {
//                    authToken = UUID.randomUUID().toString();
//                    loginToken.put(login,authToken);
//                    tokenLogin.put(authToken,login);
//                }
//                else {
//                    authToken = loginToken.get(login);
//                }
//                if (tokenLogin.containsKey(authToken)) {
//                    if (!lastActivityToken.containsKey(authToken)) {
//                        lastActivityToken.put(authToken,lastActivity);
//                    }
//                    else {
//                        lastActivityToken.replace(authToken,lastActivity);
//                    }
//                    return authToken;
//                }
//            }
//        }
        throw new LoginException("Login failed!");
    }

    public boolean isTokenValid(String authToken) {
        // Здесь таймаут!!! сравнить последнее время и если больше 30 минут удалить логин из мапов
        if (tokenLogin.containsValue(authToken)) {
            lastActivityToken.replace(authToken,getTimestamp());
            return true;
        }
        return false;
    }

    public void logout(String token) throws GeneralSecurityException {
        if (tokenLogin.containsKey(token)) {
            String login = tokenLogin.get(token);
            tokenLogin.remove(token);
            loginToken.remove(login);
            lastActivityToken.remove(token);
            return;
        }
        throw new GeneralSecurityException("Access denided!");
    }
}
