package com.sachin.cloudy.services.services;

import com.sachin.cloudy.data.entities.User;
import com.sachin.cloudy.services.exception.CloudyServiceException;

/**
 * Created by sachinhooda on 24/8/17.
 */
public interface AdminService {

    User save(User user) throws CloudyServiceException;

    User getByEmailId(String email) throws CloudyServiceException;
}
