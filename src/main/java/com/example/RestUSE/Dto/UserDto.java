package com.example.RestUSE.Dto;

import com.example.RestUSE.Entity.User;

public class UserDto extends BaseDto{
    public UserDto(Long id, String mail, String login) {
        super(id);
        this.mail = mail;
        this.login = login;
    }

    private String mail;
    private String login;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public static final UserDto user2UserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getMail(),
                user.getLogin()
        );
    }
}
