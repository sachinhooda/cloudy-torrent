package com.sachin.cloudy.services.services;

import com.sachin.cloudy.services.constants.ServiceConstants.NotificationTemplate;

import java.util.Map;

/**
 * This is the base contract for any Notification Manager which supports two kinds of Notifications.
 * 1. Email
 * 2. SMS
 * Created by sachinhooda on 3/10/17.
 */
public interface NotificationManagerService {
    void notifyOnEmail(Map<String, String> data, NotificationTemplate notificationTemplate);

    void notifyOnSMS(Map<String, String> data, NotificationTemplate notificationTemplate);
}
