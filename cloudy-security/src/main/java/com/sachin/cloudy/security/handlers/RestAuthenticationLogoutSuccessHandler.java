package com.sachin.cloudy.security.handlers;

import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Created by sachinhooda on 2/4/17.
 */
@Component("restAuthenticationLogoutSuccessHandler")
public class RestAuthenticationLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {


}
