package com.sachin.cloudy.services.services;

import com.sachin.cloudy.common.messaging.model.Notification;

/**
 * This is the basic interface to any kind of Notification Service which takes the final prepared Notification data to send to a User .
 * Created by sachinhooda on 3/10/17.
 */
public interface NotificationService {
    void notifyUser(Notification notification);
}
