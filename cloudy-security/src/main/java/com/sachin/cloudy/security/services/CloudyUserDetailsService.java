package com.sachin.cloudy.security.services;

import com.sachin.cloudy.common.logger.InjectLogger;
import com.sachin.cloudy.data.entities.User;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by sachinhooda on 6/5/17.
 */
@Component("cloudyUserDetailsService")
public class CloudyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @InjectLogger
    private Logger logger;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = null;
        try {
            logger.debug("Loading User for given UserName");
            user = userService.getUserByEmailId(userName);
        } catch (CloudyServiceException cse) {
            logger.error(cse.getMessage(), cse);
        }

        if (null == user) {
            throw new UsernameNotFoundException(userName + "Not Found ");
        }
        return null;
    }
}
