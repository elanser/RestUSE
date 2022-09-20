package com.example.RestUSE.Repositories.Interfaces;
import com.example.RestUSE.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    UserRole findUserRoleById(Long id);
    List<UserRole> findUserRolesByIdUserIs(Long id);

}
