package com.sachin.cloudy.services.services;

import com.sachin.cloudy.data.entities.User;
import com.sachin.cloudy.services.exception.CloudyServiceException;

/**
 * Created by sachinhooda on 25/2/17.
 */
public interface UserService {

    User save(User user) throws CloudyServiceException;

    User getUserByEmailId(String email) throws CloudyServiceException;
}
