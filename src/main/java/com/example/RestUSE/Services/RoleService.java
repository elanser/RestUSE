package com.example.RestUSE.Services;

import com.example.RestUSE.Entity.Role;
import com.example.RestUSE.Repositories.Interfaces.RoleRepository;
import com.example.RestUSE.Services.Interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleService implements IRoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByNamerole(String name) {
        return roleRepository.findByNamerole(name).orElse(null);
    }
}
