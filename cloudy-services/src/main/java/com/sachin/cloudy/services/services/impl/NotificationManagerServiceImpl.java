package com.sachin.cloudy.services.services.impl;

import com.sachin.cloudy.services.constants.ServiceConstants.NotificationTemplate;
import com.sachin.cloudy.services.services.NotificationManagerService;
import com.sachin.cloudy.services.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by sachinhooda on 3/10/17.
 */
@Service
public class NotificationManagerServiceImpl implements NotificationManagerService {


    private NotificationService emailNotificationService;

    private NotificationService smsNotificationService;

    @Autowired
    public NotificationManagerServiceImpl(@Qualifier("emailNotificationService") NotificationService emailNotificationService, @Qualifier("SMSNotificationService") NotificationService smsNotificationService) {
        this.emailNotificationService = emailNotificationService;
        this.smsNotificationService = smsNotificationService;
    }

    @Override
    public void notifyOnEmail(Map<String, String> data, NotificationTemplate notificationTemplate) {

        //TODO
    }

    @Override
    public void notifyOnSMS(Map<String, String> data, NotificationTemplate notificationTemplate) {

        //TODO
    }
}
