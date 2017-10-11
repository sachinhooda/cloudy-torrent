package com.sachin.cloudy.web.rest.controllers;

import com.sachin.cloudy.common.constants.CommonConstants;
import com.sachin.cloudy.common.exception.CloudyException;
import com.sachin.cloudy.data.entities.Privilege;
import com.sachin.cloudy.services.commons.dto.PrivilegeDTO;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.PrivilegeService;
import com.sachin.cloudy.web.constants.CloudyWebConstants.URLS;
import com.sachin.cloudy.web.exception.CloudyRestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by sachinhooda on 11/8/17.
 */
@RestController
@RequestMapping(value = URLS.URL_BASE)
public class PrivilegeController {

    private PrivilegeService privilegeService;

    @Autowired
    public PrivilegeController(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }

    @RequestMapping(value = URLS.URL_PRIVILEGE, method = RequestMethod.POST)
    public PrivilegeDTO create(@Valid @RequestBody PrivilegeDTO privilegeDTO)
            throws CloudyRestException {
        try {
            Privilege privilege = PrivilegeDTO.fromDTO(null, privilegeDTO);
            privilege.setCreatedDate(LocalDateTime.now());
            privilege = privilegeService.save(privilege);

            return PrivilegeDTO.toDTO(privilege);

        } catch (CloudyServiceException cse) {
            throw new CloudyRestException(cse.getMessage(), cse);
    }
    }

    @RequestMapping(value = URLS.URL_PRIVILEGE + "/{id}", method = RequestMethod.PUT)
    public PrivilegeDTO update(@Valid @RequestBody PrivilegeDTO privilegeDTO, @PathVariable(
            value = "id") Long id) throws CloudyRestException {
        try {
            Privilege privilege = privilegeService.get(id);
            privilege = PrivilegeDTO.fromDTO(privilege, privilegeDTO);
            privilege = privilegeService.save(privilege);

            return PrivilegeDTO.toDTO(privilege);

        } catch (CloudyServiceException cse) {
            throw new CloudyRestException(cse.getMessage(), cse);
    }
    }

    @RequestMapping(value = URLS.URL_PRIVILEGE + "/{property}" + "/{param}",
            method = RequestMethod.GET)
    public PrivilegeDTO get(@PathVariable(value = "property") String property,
                            @PathVariable("param") String param) throws CloudyException {
        try {
            Privilege privilege;
            if (property.equalsIgnoreCase(CommonConstants.PROPERTY_ID)) {
                privilege = privilegeService.get(Long.valueOf(param));
            } else if (property.equalsIgnoreCase(CommonConstants.PROPERTY_NAME)) {
                privilege = privilegeService.getByName(param);
            } else {
                throw new CloudyException("Wrong Search Property");
            }

            return PrivilegeDTO.toDTO(privilege);

        } catch (CloudyServiceException cse) {
            throw new CloudyRestException(cse.getMessage(), cse);
    }
    }

    @RequestMapping(value = URLS.URL_PRIVILEGES, method = RequestMethod.GET)
    public List<PrivilegeDTO> getAll() throws CloudyRestException {
        try {
            List<Privilege> privileges = privilegeService.getAll();

            return PrivilegeDTO.toDTO(privileges);

        } catch (CloudyServiceException cse) {
            throw new CloudyRestException(cse.getMessage(), cse);
    }
    }


}
