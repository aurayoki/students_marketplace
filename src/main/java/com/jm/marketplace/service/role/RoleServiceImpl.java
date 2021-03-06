package com.jm.marketplace.service.role;

import com.jm.marketplace.config.mapper.MapperFacade;
import com.jm.marketplace.dao.RoleDao;
import com.jm.marketplace.dto.RoleDto;
import com.jm.marketplace.exception.RoleNotFoundException;
import com.jm.marketplace.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao, MapperFacade mapperFacade) {
        this.roleDao = roleDao;
        this.mapperFacade = mapperFacade;
    }

    @Transactional(readOnly = true)
    @Override
    public List<RoleDto> findAll() {
        return mapperFacade.mapAsList(roleDao.findAll(), RoleDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public RoleDto findById(Long id) {
        Role role = roleDao.findById(id).orElseThrow(() ->
                new RoleNotFoundException(String.format("Role not found by id: %s", id)));
        return mapperFacade.map(role, RoleDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public RoleDto findByName(String name) {
        Role role = roleDao.findByName(name).orElseThrow(() ->
                new RoleNotFoundException(String.format("Role not found by name: %s", name)));
        return mapperFacade.map(role, RoleDto.class);
    }
}
