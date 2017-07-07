package com.sachin.cloudy.services.services;

import com.sachin.cloudy.data.entities.Role;
import com.sachin.cloudy.services.exception.CloudyServiceException;

import java.util.List;

/**
 * Created by sachinhooda on 8/7/17.
 */
public interface RoleService {
    List<Role> getAll() throws CloudyServiceException;

    Role get(Long id) throws CloudyServiceException;

    Role save(Role role) throws CloudyServiceException;
}
