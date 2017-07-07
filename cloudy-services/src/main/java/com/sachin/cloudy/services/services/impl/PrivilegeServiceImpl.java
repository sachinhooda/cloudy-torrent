package com.sachin.cloudy.services.services.impl;

import com.sachin.cloudy.data.entities.Privilege;
import com.sachin.cloudy.data.repositories.PrivilegeRepository;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sachinhooda on 8/7/17.
 */
@Service
@Transactional
public class PrivilegeServiceImpl implements PrivilegeService {

    private PrivilegeRepository privilegeRepository;

    @Autowired
    public PrivilegeServiceImpl(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    @Override
    public List<Privilege> getAll() throws CloudyServiceException {
        try {
            return privilegeRepository.findAll();
        } catch (Exception e) {
            throw new CloudyServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Privilege get(Long id) throws CloudyServiceException {
        try {
            Privilege privilege = privilegeRepository.findOne(id);
            if (null == privilege) {
                throw new CloudyServiceException("Resource Not Found");
            }
            return privilege;
        } catch (Exception e) {
            throw new CloudyServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Privilege save(Privilege privilege) throws CloudyServiceException {
        try {
            return privilegeRepository.save(privilege);
        } catch (Exception e) {
            throw new CloudyServiceException(e.getMessage(), e);
        }
    }
}
