package com.sachin.cloudy.services.services.impl;

import com.sachin.cloudy.data.entities.Role;
import com.sachin.cloudy.data.repositories.RoleRepository;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.ClosedDirectoryStreamException;
import java.util.List;

/**
 * Created by sachinhooda on 8/7/17.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAll() throws CloudyServiceException {
        try {
            return roleRepository.findAll();
        } catch (Exception e) {
            throw new CloudyServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Role get(Long id) throws CloudyServiceException {
        try {
            Role role = roleRepository.findOne(id);
            if (role == null) {
                throw new CloudyServiceException("Resource not found");
            }
            return role;
        } catch (Exception e) {
            throw new CloudyServiceException(e.getMessage(), e);
        }

    }

    @Override
    public Role save(Role role) throws CloudyServiceException {
        try {
            return roleRepository.save(role);
        } catch (Exception e) {
            throw new CloudyServiceException(e.getMessage(), e);
        }

    }
}
