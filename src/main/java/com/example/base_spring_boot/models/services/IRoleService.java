package com.example.base_spring_boot.models.services;

import com.example.base_spring_boot.models.constants.RoleName;
import com.example.base_spring_boot.models.entities.Role;

public interface IRoleService {
    Role findByRoleName(RoleName roleName);
}
