package com.sachin.cloudy.services.commons.dto;

import com.sachin.cloudy.data.entities.Privilege;
import com.sachin.cloudy.data.entities.Role;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.PrivilegeService;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sachinhooda on 15/8/17.
 */
public class RoleDTO {

    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

    private String description;

    private List<PrivilegeDTO> privileges;

    public RoleDTO() {
        super();
    }

    public RoleDTO(Long id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PrivilegeDTO> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PrivilegeDTO> privileges) {
        this.privileges = privileges;
    }

    public static Role fromDTO(Role roleParam, RoleDTO rolesDTO, PrivilegeService privilegeService)
            throws CloudyServiceException {
        Role role;
        if (roleParam == null) {
            role = new Role();
        } else {
            role = roleParam;
    }
        if (null != rolesDTO.getName()) {
            role.setName(rolesDTO.getName());
    }
        if (null != rolesDTO.getDescription()) {
            role.setDescription(rolesDTO.getDescription());
    }
        if (null != rolesDTO.getPrivileges()) {
            List<Privilege> privilegeList = new ArrayList<>();
            for (PrivilegeDTO privilegeDTO : rolesDTO.getPrivileges()) {
                Privilege privilege = privilegeService.getByName(privilegeDTO.getName());
                privilegeList.add(privilege);
            }
            role.setPrivileges(privilegeList);
        }

        return role;
    }

    public static RoleDTO toDTO(Role role) {
        return new RoleDTO(role.getId(), role.getName(), role.getDescription());
    }

    public static List<RoleDTO> toDTO(List<Role> roles) {
        List<RoleDTO> roleDTOs = new ArrayList<>();
        for (Role role : roles) {
            roleDTOs.add(RoleDTO.toDTO(role));
    }
        return roleDTOs;
    }
}
