package com.example.base_spring_boot.models.services.impl;

import com.example.base_spring_boot.exceptions.HttpNotFoundException;
import com.example.base_spring_boot.models.constants.RoleName;
import com.example.base_spring_boot.models.entities.Role;
import com.example.base_spring_boot.models.repositories.IRoleRepository;
import com.example.base_spring_boot.models.services.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {
    private final IRoleRepository roleRepository;

    @Override
    public Role findByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName).orElseThrow(() -> new HttpNotFoundException("role: " + roleName + " not found"));
    }
}