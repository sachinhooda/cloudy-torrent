package com.sachin.cloudy.web.rest.controllers;

import com.sachin.cloudy.services.services.PrivilegeService;
import com.sachin.cloudy.services.services.RoleService;
import com.sachin.cloudy.web.constants.CloudyWebConstants.URLS;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sachinhooda on 8/7/17.
 */
@Controller
@RequestMapping(value = URLS.URL_BASE)
public class RoleController {

    private RoleService roleService;
    private PrivilegeService privilegeService;

    @Autowired
    public RoleController(RoleService roleService, PrivilegeService privilegeService) {
        this.roleService = roleService;
        this.privilegeService = privilegeService;
    }


}
