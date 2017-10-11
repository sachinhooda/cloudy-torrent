package com.sachin.cloudy.services.services.impl;

import com.sachin.cloudy.common.logger.InjectLogger;
import com.sachin.cloudy.common.messaging.model.Notification;
import com.sachin.cloudy.services.constants.ServiceConstants;
import com.sachin.cloudy.services.constants.ServiceConstants.NotificationTemplate;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.NotificationManagerService;
import com.sachin.cloudy.services.services.NotificationService;
import com.sachin.cloudy.services.services.TemplatingService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.sachin.cloudy.services.constants.ServiceConstants.NotificationTargetType.EMAIL;
import static com.sachin.cloudy.services.constants.ServiceConstants.NotificationTargetType.SMS;

/**
 * Created by sachinhooda on 3/10/17.
 */
@Service
public class NotificationManagerServiceImpl implements NotificationManagerService {

    @InjectLogger
    private Logger logger;

    private TemplatingService templatingService;

    private NotificationService emailNotificationService;

    private NotificationService smsNotificationService;

    @Autowired
    public NotificationManagerServiceImpl(
            @Qualifier("EmailNotificationService") NotificationService emailNotificationService,
            @Qualifier("SMSNotificationService") NotificationService smsNotificationService,
            TemplatingService templatingService) {
        this.emailNotificationService = emailNotificationService;
        this.smsNotificationService = smsNotificationService;
        this.templatingService = templatingService;
    }

    @Override
    public void notifyOnEmail(Map<String, String> data, NotificationTemplate notificationTemplate)
            throws CloudyServiceException {

        String body = templatingService.resolveTemplate(data, EMAIL, notificationTemplate);
        logger.debug(String.format("Sending notification : %s ......", body));
        Notification notification = new Notification();
        notification.setBody(body);
        notification.setNotificationType(ServiceConstants.NOTIFICATION_TYPE_EMAIL);

        emailNotificationService.notifyUser(notification);

        // TODO
    }

    @Override
    public void notifyOnSMS(Map<String, String> data, NotificationTemplate notificationTemplate)
            throws CloudyServiceException {

        String body = templatingService.resolveTemplate(data, SMS, notificationTemplate);
        logger.debug(String.format("Sending notification : %s ......", body));
        Notification notification = new Notification();
        notification.setBody(body);
        notification.setNotificationType(ServiceConstants.NOTIFICATION_TYPE_SMS);
        smsNotificationService.notifyUser(notification);

        // TODO
    }


}
