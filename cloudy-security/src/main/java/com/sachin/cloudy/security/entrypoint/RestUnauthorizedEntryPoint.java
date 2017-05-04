package com.sachin.cloudy.security.entrypoint;

import com.sachin.cloudy.security.utils.SecurityUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by sachinhooda on 28/3/17.
 */
@Component("restAuthenticationEntryPoint")
public class RestUnauthorizedEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException,
            ServletException {
        SecurityUtils.sendError(httpServletResponse, httpServletRequest, HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
    }
}
