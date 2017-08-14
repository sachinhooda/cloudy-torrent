package com.sachin.cloudy.services.services;

import com.sachin.cloudy.data.entities.Privilege;
import com.sachin.cloudy.services.exception.CloudyServiceException;

import java.util.List;

/**
 * Created by sachinhooda on 8/7/17.
 */
public interface PrivilegeService {
    List<Privilege> getAll() throws CloudyServiceException;

    Privilege get(Long id) throws CloudyServiceException;

    Privilege save(Privilege privilege) throws CloudyServiceException;

    Privilege getByName(String name) throws CloudyServiceException;
}
