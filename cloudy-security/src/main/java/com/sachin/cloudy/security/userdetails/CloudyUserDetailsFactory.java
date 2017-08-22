package com.sachin.cloudy.security.userdetails;

import com.sachin.cloudy.data.entities.Privilege;
import com.sachin.cloudy.data.entities.Role;
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

        Set<Privilege> allPrivileges = getAllPrivilege(user.getRoles());
        List<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(allPrivileges);

        return new CloudyUserDetails(user.getId(), user.getEmail(), user.getFirstName(),
                user.getLastName(), user.getPassword(), user.getEmail(), grantedAuthorities, true, null);

    }

    private static Set<Privilege> getAllPrivilege(Collection<Role> roles) {
        Set<Privilege> privileges = new HashSet<>();
        for (Role role : roles) {
            privileges.addAll(role.getPrivileges());
    }
        return privileges;
    }

    private static List<GrantedAuthority> getGrantedAuthorities(Collection<Privilege> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Privilege privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege.getName()));
        }
        return authorities;
    }


}
