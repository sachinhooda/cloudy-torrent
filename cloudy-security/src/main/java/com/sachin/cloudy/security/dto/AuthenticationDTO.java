package com.sachin.cloudy.security.dto;

import java.util.List;

/**
 * Created by sachinhooda on 18/4/17.
 */
public class AuthenticationDTO {
    private String email;

    private String firstName;

    private String lastName;

    private String token;

    private List<String> authorities;

    private List<String> roles;

    public AuthenticationDTO(String email, String firstName, String lastName, String token,
                             List<String> authorities, List<String> roles) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.token = token;
        this.authorities = authorities;
        this.roles = roles;
    }

    public String getToken() {
        return this.token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getPrivileges() {
        return authorities;
    }

    public void setPrivileges(List<String> authorities) {
        this.authorities = authorities;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}
