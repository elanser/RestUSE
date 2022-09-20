package com.example.RestUSE.Services;

import com.example.RestUSE.Dto.UserDto;
import com.example.RestUSE.Entity.Role;
import com.example.RestUSE.Entity.User;

import com.example.RestUSE.Entity.UserRole;
import com.example.RestUSE.Repositories.Interfaces.RoleRepository;
import com.example.RestUSE.Repositories.Interfaces.UserRepository;
import com.example.RestUSE.Repositories.Interfaces.UserRoleRepository;
import com.example.RestUSE.Services.Interfaces.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService implements IUserService {
    UserRepository userRepositoryJPA;
    RoleRepository roleRepository;

    public UserService(UserRepository userRepositoryJPA, RoleRepository roleRepository, UserRoleRepository userRoleRepository) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    UserRoleRepository userRoleRepository;

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepositoryJPA.findByLogin(login);
    }

    @Override
    public UserDto getUserById(Long iD) {
        return UserDto.user2UserDto(userRepositoryJPA.getUserById(iD).orElse(new User()));
    }

    @Override
    public  List<UserDto> getUsersJPA() {
//        Supplier<List<User>> supplierUsers =
//                () -> userRepositoryJPA.getUsersJPA().orElse(new ArrayList<>());
//        CompletableFuture<List<User>> cfUsers = CompletableFuture.supplyAsync(supplierUsers);
        List<User> users = userRepositoryJPA.getUsersJPA().orElse(new ArrayList<>());
        log.info("Convert User list to Dto User List");
        List<UserDto> usersDto =  users.stream().map(UserDto::user2UserDto).collect(Collectors.toList());
        return usersDto;
    }

    @Override
    public Boolean isUser(String login) {
        return userRepositoryJPA.isUser(login).isPresent();
    }

    @Override
    public UserDto getUserByLoginPassword(String login, String password) {
        return null;
    }

    @Override
    public UserDto getUserByLoginPasswordJPA(String login, String password) {
        return UserDto.user2UserDto(userRepositoryJPA.findByLoginAndPassword(login,password).orElse(new User()));
    }

    @Override
    public UserDto getUserByLoginPasswordJPAQuery(String login, String password) {
//        Supplier<User> supplierUser =
//                () -> {
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
            return UserDto.user2UserDto(userRepositoryJPA.queryUserByLoginPassword(login,password).orElse(new User()));
//        };
//        CompletableFuture<User> cfUser =
//                CompletableFuture.supplyAsync(supplierUser);
       // return cfUser;
    }

    @Override
    public UserDto registerUser(String login, String password, String email) {
        Role role = roleRepository.findByNamerole("USER");
        UserRole userRole = new UserRole();
        if (role !=null) {
            User user = userRepositoryJPA.findByLogin(login).orElse(null);
            if (user==null) {
                user = new User();
                user.setLogin(login);
                user.setMail(email);
                user.setPassword(password);
                userRepositoryJPA.save(user);
                userRole.setIdUser(user);
                userRole.setIdRole(role);
                userRoleRepository.save(userRole);
                log.info("IN registerUser - user: {} successfully registered", user.getLogin());
                return UserDto.user2UserDto(user);
            } else {
                log.info("IN registerUser - user: {} already registered", user.getLogin());
            }
        }
        log.error("IN registerUser Error!");
        return null;
    }

}
