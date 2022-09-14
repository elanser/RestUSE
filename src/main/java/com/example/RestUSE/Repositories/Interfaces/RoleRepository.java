package com.example.RestUSE.Repositories.Interfaces;

import com.example.RestUSE.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNamerole(String name);
}
