package com.sachin.cloudy.web.rest.controllers;

import com.sachin.cloudy.data.entities.User;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.UserService;
import com.sachin.cloudy.web.constants.CloudyWebConstants.URLS;
import com.sachin.cloudy.web.exception.CloudyRestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sachinhooda on 18/2/17.
 */
@RestController
@RequestMapping(value = URLS.URL_BASE)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = URLS.URL_USER, method = RequestMethod.POST)
    public User registerUser() throws CloudyRestException{

        try {
            User user=new User();
            user.setBirthDate("14-02-1994");
            user.setDataUsageStats(null);
            user.setEmail("sachinhooda@hotmail.com");
            user.setFirstName("Sachin");
            user.setGender("Male");
            user.setLastName("Hooda");
            user.setPassword("NoPassword");
            user.setTorrentsUsageStats(null);

            user=userService.save(user);
            return user;
        }  catch (CloudyServiceException cse) {
            throw new CloudyRestException(cse.getMessage(),cse);
        }



    }
}
