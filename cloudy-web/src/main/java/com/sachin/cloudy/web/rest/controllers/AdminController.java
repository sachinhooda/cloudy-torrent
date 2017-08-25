package com.sachin.cloudy.web.rest.controllers;

import com.sachin.cloudy.data.entities.User;
import com.sachin.cloudy.services.commons.dto.UserDTO;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.AdminService;
import com.sachin.cloudy.web.constants.CloudyWebConstants;
import com.sachin.cloudy.web.exception.CloudyRestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created by sachinhooda on 24/8/17.
 */
@RestController
@RequestMapping(value = CloudyWebConstants.URLS.URL_BASE)
public class AdminController {


    private AdminService adminService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = CloudyWebConstants.URLS.URL_ADMIN, method = RequestMethod.POST)
    public UserDTO registerAdmin(@RequestBody UserDTO userDTO) throws CloudyRestException {

        try {
            User user = UserDTO.fromDTO(null, userDTO);

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setCreatedDate(LocalDateTime.now());

            user = adminService.save(user);
            return UserDTO.toDTO(user);
        } catch (CloudyServiceException cse) {
            throw new CloudyRestException(cse.getMessage(), cse);
        }


    }

}
