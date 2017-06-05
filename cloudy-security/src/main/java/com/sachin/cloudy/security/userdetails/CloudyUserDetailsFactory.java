package com.sachin.cloudy.security.userdetails;

import com.sachin.cloudy.data.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

/**
 * Created by sachinhooda on 10/5/17.
 */
public class CloudyUserDetailsFactory {

    private CloudyUserDetailsFactory() {
    }

    public static CloudyUserDetails create(User user) {

        return new CloudyUserDetails(user.getId(), user.getEmail(), user.getFirstName(),
                user.getLastName(), user.getPassword(),user.getEmail(), null,
                true, null);

    }


}
