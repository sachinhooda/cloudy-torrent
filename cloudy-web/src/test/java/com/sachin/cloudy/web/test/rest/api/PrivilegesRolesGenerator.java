package com.sachin.cloudy.web.test.rest.api;


import com.sachin.cloudy.data.entities.Privilege;
import com.sachin.cloudy.data.entities.Role;
import com.sachin.cloudy.web.constants.CloudyWebConstants.URLS;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sachinhooda on 25/8/17.
 */
public class PrivilegesRolesGenerator {
  public PrivilegesRolesGenerator() {
    createPrivileges();
    createRoles();
  }

  public void createPrivileges() {
    createPrivilegeWithParameters("ADD_TORRENT");
    createPrivilegeWithParameters("REMOVE_TORRENT");
    createPrivilegeWithParameters("CHANGE_PASSWORD");
    createPrivilegeWithParameters("VIEW_ALL_TORRENT");
    createPrivilegeWithParameters("DOWNLOAD_TORRENT");
    createPrivilegeWithParameters("VIEW_PROFILE");

  }

  public void createRoles() {
    Privilege ADD_TORRENT = getPrivilege("ADD_TORRENT");
    Privilege REMOVE_TORRENT = getPrivilege("REMOVE_TORRENT");
    Privilege CHANGE_PASSWORD = getPrivilege("CHANGE_PASSWORD");
    Privilege VIEW_ALL_TORRENT = getPrivilege("VIEW_ALL_TORRENT");
    Privilege DOWNLOAD_TORRENT = getPrivilege("DOWNLOAD_TORRENT");
    Privilege VIEW_PROFILE = getPrivilege("VIEW_PROFILE");

    List<Privilege> privileges = new ArrayList<>();
    privileges.add(VIEW_PROFILE);
    privileges.add(CHANGE_PASSWORD);

    createRoleWithParameters("ROLE_ADMIN", privileges);

    privileges = new ArrayList<>();
    privileges.add(VIEW_PROFILE);
    privileges.add(CHANGE_PASSWORD);
    privileges.add(ADD_TORRENT);
    privileges.add(REMOVE_TORRENT);
    privileges.add(VIEW_ALL_TORRENT);
    privileges.add(DOWNLOAD_TORRENT);

    createRoleWithParameters("ROLE_USER", privileges);


  }

  public void createPrivilegeWithParameters(String name) {

    String url = CommonFunctions.URL_BASE + URLS.URL_PRIVILEGE;
    RestTemplate restTemplate = new RestTemplate();
    Privilege privilege = new Privilege();
    privilege.setName(name);
    privilege.setDescription(name);
    restTemplate.postForObject(url, privilege, Privilege.class);


  }

  public void createRoleWithParameters(String name, List<Privilege> privileges) {

    String url = CommonFunctions.URL_BASE + URLS.URL_ROLE;
    RestTemplate restTemplate = new RestTemplate();

    Role role = new Role();
    role.setName(name);
    role.setDescription(name);
    role.setPrivileges(privileges);
    restTemplate.postForObject(url, role, Role.class);
  }

  public Privilege getPrivilege(String name) {
    RestTemplate restTemplate = new RestTemplate();
    String url = CommonFunctions.URL_BASE + URLS.URL_PRIVILEGE + URLS.URL_NAME;
    return restTemplate.getForObject(url + "/" + name, Privilege.class);
  }
}
