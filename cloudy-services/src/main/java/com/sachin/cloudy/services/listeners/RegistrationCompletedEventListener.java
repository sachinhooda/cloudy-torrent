package com.sachin.cloudy.services.listeners;

import com.sachin.cloudy.common.logger.InjectLogger;
import com.sachin.cloudy.data.entities.User;
import com.sachin.cloudy.services.constants.ServiceConstants;
import com.sachin.cloudy.services.events.RegistrationCompletedEvent;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.NotificationManagerService;
import com.sachin.cloudy.services.services.OTPService;
import com.sachin.cloudy.services.services.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sachinhooda on 4/9/17.
 */
@Component
public class RegistrationCompletedEventListener implements
        ApplicationListener<RegistrationCompletedEvent> {

    @InjectLogger
    Logger logger;

    @Autowired
    NotificationManagerService notificationManagerService;

    @Autowired
    private UserService userService;

    @Autowired
    private OTPService otpService;

    @Override
    public void onApplicationEvent(RegistrationCompletedEvent registrationCompletedEvent) {

        User user = registrationCompletedEvent.getUser();
        try {
            String token = otpService.createVerificationOTP(user);
            logger.info("OTP generated is : " + token);

            Map<String, String> data = new HashMap<>();
            data.put("to", user.getEmail());
            data.put("name", user.getFirstName());
            data.put("otp", token);
            data.put("subject", "OTP for Cloudy the Torrent");
            data.put("from", "CloudytheTorrent");
            notificationManagerService.notifyOnEmail(data, ServiceConstants.NotificationTemplate.NOTIFICATION_USER_REGISTERED);
        } catch (CloudyServiceException cse) {
            logger.error(cse.getMessage(), cse);
        }
    }
}
