package com.sachin.cloudy.services.services.impl;

import com.sachin.cloudy.data.constants.RoleConstants;
import com.sachin.cloudy.data.entities.Role;
import com.sachin.cloudy.data.entities.User;
import com.sachin.cloudy.data.repositories.RoleRepository;
import com.sachin.cloudy.data.repositories.UserRepository;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sachinhooda on 24/8/17.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public AdminServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User save(User user) throws CloudyServiceException {
        try {

            Role role = roleRepository.findOne(RoleConstants.ROLE_ADMIN);
            user.getRoles().add(role);
            user = userRepository.save(user);
            return user;
        } catch (Exception e) {
            throw new CloudyServiceException(e.getMessage(), e);
        }

    }

    @Override
    public User getByEmailId(String email) throws CloudyServiceException {
        try {
            User user = null;
            user = userRepository.findByEmail(email);
            return user;
        } catch (Exception e) {
            throw new CloudyServiceException(e.getMessage(), e);
        }

    }

}
