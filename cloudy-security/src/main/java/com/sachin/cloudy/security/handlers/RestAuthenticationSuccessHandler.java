package com.sachin.cloudy.security.handlers;

import com.sachin.cloudy.data.entities.Role;
import com.sachin.cloudy.security.dto.AuthenticationDTO;
import com.sachin.cloudy.security.userdetails.CloudyUserDetails;
import com.sachin.cloudy.security.utils.JWTTokenUtils;
import com.sachin.cloudy.security.utils.SecurityUtils;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by sachinhooda on 2/4/17.
 */
@Component("restAuthenticationSuccessHandler")
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private JWTTokenUtils jwtTokenUtils;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        CloudyUserDetails userDetails =
                (CloudyUserDetails) userDetailsService.loadUserByUsername(authentication.getName());
        Set<Role> roles = null;
        try {
            roles = userService.getUserByEmailId(userDetails.getEmail()).getRoles();
        } catch (CloudyServiceException cse) {
            logger.error("Invalid user in authentication" + cse.getMessage(), cse);
        }
        List<String> roleNames = new ArrayList<>();
        for (Role role : roles) {
            roleNames.add(role.getName());
        }
        List<String> authorities = new ArrayList<>();
        userDetails.getAuthorities().forEach(authority -> {
            authorities.add(authority.getAuthority());
        });

        Device currentDevice = DeviceUtils.getCurrentDevice(request);

        final String jwtToken = jwtTokenUtils.generateToken(userDetails, currentDevice);

        SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK, new AuthenticationDTO(
                userDetails.getEmail(), userDetails.getFirstname(), userDetails.getLastname(), jwtToken,
                authorities, roleNames));
    }
}
