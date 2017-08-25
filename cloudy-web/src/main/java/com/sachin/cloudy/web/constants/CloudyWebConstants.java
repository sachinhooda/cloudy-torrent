package com.sachin.cloudy.web.constants;

import static com.sachin.cloudy.common.constants.CommonConstants.PLURAL_SUFFIX;

/**
 * Created by sachinhooda on 18/2/17.
 */
public interface CloudyWebConstants {

    interface URLS {

        String URL_BASE = "/api";
        String URL_ADMIN = "/admin";
        String URL_USER = "/user";
        String URL_ROLE = "/role";
        String URL_PRIVILEGE = "/privilege";
        String URL_NAME = "/name";
        String URL_PRIVILEGES = URL_PRIVILEGE + PLURAL_SUFFIX;
        String URL_ROLES = URL_ROLE + PLURAL_SUFFIX;

    }
}
