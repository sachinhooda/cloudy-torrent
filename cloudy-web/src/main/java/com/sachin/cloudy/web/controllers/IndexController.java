package com.sachin.cloudy.web.controllers;

import com.sachin.cloudy.common.exception.CloudyException;

import com.sachin.cloudy.common.logger.InjectLogger;
import com.sachin.cloudy.web.constants.CloudyWebConstants.URLS;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by sachinhooda on 18/2/17.
 */
@RestController
@RequestMapping(value = "/")
public class IndexController {

    @InjectLogger
    private Logger logger;

    @RequestMapping(method = RequestMethod.GET, value = URLS.URL_USER)
    public String testOutput() throws CloudyException {

        logger.info("In index Controller now");
        return "Testing is good";

    }
}
