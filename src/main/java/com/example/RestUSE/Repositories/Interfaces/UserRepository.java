package com.example.RestUSE.Repositories.Interfaces;

import com.example.RestUSE.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    // Здесь только пишем заголовок ф-ции, а Hibernate сам генерирует код. Нам ничего делать не надо
    // Главное правильно написать поля !
    Optional<User> findByLogin(String login);
    // And... Or... Contains... - Можно
    Optional<User> findByLoginAndPassword(String login, String password);

    // https://sysout.ru/annotatsiya-query/

    @Transactional(readOnly = true)
    @Query("SELECT u FROM User u WHERE u.login = :login and u.password = :password")
    Optional<User> queryUserByLoginPassword(String login, String password);

    @Transactional(readOnly = true)
    @Query("SELECT u FROM User u")
    Optional<List<User>> getUsersJPA();

    @Transactional(readOnly = true)
    @Query("SELECT u FROM User u WHERE u.id = :iD")
    Optional<User> getUserById(long iD);

    @Transactional(readOnly = true)
    @Query("SELECT u FROM User u WHERE u.login = :login")
    Optional<User> isUser(String login);

}
