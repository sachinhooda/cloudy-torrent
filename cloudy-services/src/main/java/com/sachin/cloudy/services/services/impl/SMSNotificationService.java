package com.sachin.cloudy.services.services.impl;

import com.sachin.cloudy.common.logger.InjectLogger;
import com.sachin.cloudy.common.messaging.model.Notification;
import com.sachin.cloudy.services.services.NotificationService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by sachinhooda on 3/10/17.
 */
@Service
@Qualifier("SMSNotificationService")
public class SMSNotificationService implements NotificationService {

    @InjectLogger
    private Logger logger;

    @Override
    public void notifyUser(Notification notification) {

        // TODO
    }
}
