package com.sachin.cloudy.security.handlers;

import com.sachin.cloudy.security.utils.SecurityUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sachinhooda on 2/4/17.
 */
@Component("restAuthenticationFailureHandler")
public class RestAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        SecurityUtils.sendError(response, request, HttpServletResponse.SC_UNAUTHORIZED,
                exception.getMessage());
    }
}
