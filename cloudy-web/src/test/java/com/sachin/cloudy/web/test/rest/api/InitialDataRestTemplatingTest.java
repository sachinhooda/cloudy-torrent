package com.sachin.cloudy.web.test.rest.api;

import com.sachin.cloudy.data.entities.Privilege;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;


/**
 * Created by sachinhooda on 23/8/17.
 */
public class InitialDataRestTemplatingTest {

    private RestTemplate restTemplate;


    @Test
    public void test() {

        createPrivileges();
        createRoles();

    }

    public void createPrivileges() {


    }

    public void createRoles() {

    }

    public void createPrivilegeWithParameters(String name) {


    }

    public void createRoleWithParameters(String name, List<Privilege> privileges) {

    }
}
