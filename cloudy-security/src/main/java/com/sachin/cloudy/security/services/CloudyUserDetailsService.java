package com.sachin.cloudy.security.services;

import com.sachin.cloudy.common.logger.InjectLogger;
import com.sachin.cloudy.data.entities.User;
import com.sachin.cloudy.security.userdetails.CloudyUserDetailsFactory;
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

    public CloudyUserDetailsService() {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = null;
        try {
            // logger.debug("Loading User for given UserName");
            user = this.userService.getUserByEmailId(username);
        } catch (CloudyServiceException cse) {
            logger.error(cse.getMessage(), cse);
        }

        if (null == user) {
            throw new UsernameNotFoundException(username + "Not Found ");
        }
        return CloudyUserDetailsFactory.create(user);
    }
}
