package com.sachin.cloudy.services.services;

import com.sachin.cloudy.services.constants.ServiceConstants.NotificationTargetType;
import com.sachin.cloudy.services.constants.ServiceConstants.NotificationTemplate;
import com.sachin.cloudy.services.exception.CloudyServiceException;

import java.util.Map;

/**
 * Created by sachinhooda on 4/10/17.
 */
public interface TemplatingService {

  String resolveTemplate(Map<String, String> data, NotificationTargetType notificationTargetType,
                         NotificationTemplate notificationTemplate) throws CloudyServiceException;
}
