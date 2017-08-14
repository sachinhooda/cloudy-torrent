package com.sachin.cloudy.web.rest.controllers;


import com.sachin.cloudy.data.entities.Role;
import com.sachin.cloudy.services.commons.dto.RoleDTO;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.PrivilegeService;
import com.sachin.cloudy.services.services.RoleService;
import com.sachin.cloudy.web.constants.CloudyWebConstants.URLS;
import com.sachin.cloudy.web.exception.CloudyRestException;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

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


    @RequestMapping(value = URLS.URL_ROLE, method = RequestMethod.POST)
    public RoleDTO create(@Valid @RequestBody RoleDTO roleDTO) throws CloudyRestException {
        try {
            Role role = RoleDTO.fromDTO(null, roleDTO, privilegeService);
            role = roleService.save(role);

            return RoleDTO.toDTO(role);

        } catch (CloudyServiceException cse) {
            throw new CloudyRestException(cse.getMessage(), cse);
        }
    }

    @RequestMapping(value = URLS.URL_ROLE + "/{id}", method = RequestMethod.PUT)
    public RoleDTO update(@Valid @RequestBody RoleDTO roleDTO, @PathVariable(value = "id") Long id) throws CloudyRestException {
        try {

            Role role = roleService.get(id);
            role = RoleDTO.fromDTO(role, roleDTO, privilegeService);
            role = roleService.save(role);

            return RoleDTO.toDTO(role);

        } catch (CloudyServiceException cse) {
            throw new CloudyRestException(cse.getMessage(), cse);
        }
    }

    @RequestMapping(value = URLS.URL_ROLE + "/{id}", method = RequestMethod.GET)
    public RoleDTO get(@PathVariable(value = "id") Long id) throws CloudyRestException {
        try {
            Role role = roleService.get(id);

            return RoleDTO.toDTO(role);

        } catch (CloudyServiceException cse) {
            throw new CloudyRestException(cse.getMessage(), cse);
        }
    }

    @RequestMapping(value = URLS.URL_ROLES, method = RequestMethod.GET)
    public List<RoleDTO> getAll() throws CloudyRestException {
        try {
            List<Role> roles = roleService.getAll();

            return RoleDTO.toDTO(roles);

        } catch (CloudyServiceException cse) {
            throw new CloudyRestException(cse.getMessage(), cse);
        }
    }


}
