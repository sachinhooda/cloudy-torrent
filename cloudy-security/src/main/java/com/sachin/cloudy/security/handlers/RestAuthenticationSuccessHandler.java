package com.sachin.cloudy.security.handlers;

import com.sachin.cloudy.security.dto.AuthenticationDTO;
import com.sachin.cloudy.security.userdetails.CloudyUserDetails;
import com.sachin.cloudy.security.utils.SecurityUtils;
import com.sachin.cloudy.services.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        CloudyUserDetails userDetails = (CloudyUserDetails) userDetailsService.loadUserByUsername(authentication.getName());


        SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK, new AuthenticationDTO(userDetails.getEmail(),
                userDetails.getFirstname(), userDetails.getLastname(), null, null, null));
    }
}
