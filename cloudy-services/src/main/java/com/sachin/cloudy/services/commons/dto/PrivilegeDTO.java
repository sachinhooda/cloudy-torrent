package com.sachin.cloudy.services.commons.dto;

import com.sachin.cloudy.data.entities.Privilege;
import com.sachin.cloudy.data.entities.Role;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sachinhooda on 15/8/17.
 */
public class PrivilegeDTO {

    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

    private String description;

    public PrivilegeDTO() {
        super();
    }

    public PrivilegeDTO(Long id, String name, String description) {
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

    public static Privilege fromDTO(Privilege privilegeParam, PrivilegeDTO privilegeDTO) {
        Privilege privilege;
        if (privilegeParam == null) {
            privilege = new Privilege();
        } else {
            privilege = privilegeParam;
        }

        privilege.setName(privilegeDTO.getName());

        if (null != privilegeDTO.getDescription()) {
            privilege.setDescription(privilegeDTO.getDescription());
        }

        return privilege;
    }

    public static PrivilegeDTO toDTO(Privilege privilege) {
        return new PrivilegeDTO(privilege.getId(), privilege.getName(), privilege.getDescription());
    }

    public static List<PrivilegeDTO> toDTO(List<Privilege> privileges) {
        List<PrivilegeDTO> privilegeDTOs = new ArrayList<>();
        for (Privilege privilege : privileges) {
            privilegeDTOs.add(PrivilegeDTO.toDTO(privilege));
        }
        return privilegeDTOs;
    }

}
