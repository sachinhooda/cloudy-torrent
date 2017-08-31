package com.sachin.cloudy.web.rest.controllers;

import com.sachin.cloudy.services.services.OTPService;
import com.sachin.cloudy.services.services.UserService;
import com.sachin.cloudy.web.constants.CloudyWebConstants.URLS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sachinhooda on 31/8/17.
 */
@RestController
@RequestMapping(value = URLS.URL_BASE)
public class OTPController {

    private UserService userService;

    private OTPService otpService;

    @Autowired
    public OTPController(UserService userService, OTPService otpService) {
        this.userService = userService;
        this.otpService = otpService;
    }
}
