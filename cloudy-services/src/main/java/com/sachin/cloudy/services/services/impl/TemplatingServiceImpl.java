package com.sachin.cloudy.services.services.impl;

import com.sachin.cloudy.common.logger.InjectLogger;
import com.sachin.cloudy.services.constants.ServiceConstants;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.TemplatingService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by sachinhooda on 4/10/17.
 */
@Service
public class TemplatingServiceImpl implements TemplatingService {

    @InjectLogger
    private Logger logger;

    @Override
    public String resolveTemplate(Map<String, String> data, ServiceConstants.NotificationTargetType notificationTargetType, ServiceConstants.NotificationTemplate notificationTemplate) throws CloudyServiceException {
        return null;
    }
}
