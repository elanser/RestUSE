package com.example.RestUSE.Repositories.Interfaces;

import com.example.RestUSE.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByNamerole(String name);

    @Transactional(readOnly = true)
    @Query("SELECT r FROM UserRole ur INNER JOIN Role r ON ur.idRole.id=r.id WHERE ur.idUser.id = :id")
    List<Role> findRolesByUserId(Long id);
}
