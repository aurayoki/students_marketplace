package com.jm.marketplace.service.role;

import com.jm.marketplace.dto.RoleDto;

import java.util.List;

public interface RoleService {

    List<RoleDto> findAll();
    RoleDto findById(Long id);
    RoleDto findByName(String name);
}
