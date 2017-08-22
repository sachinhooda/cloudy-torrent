package com.sachin.cloudy.security.handlers;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sachinhooda on 19/8/17.
 */
@Component("jwtAuthenticationSuccesshandler")
public class JWTAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        String context = request.getContextPath();
        String fullURI = request.getRequestURI();
        String url = fullURI.substring(fullURI.indexOf(context) + context.length());
        return url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String url = determineTargetUrl(request, response);
        request.getRequestDispatcher(url).forward(request, response);
    }
}
