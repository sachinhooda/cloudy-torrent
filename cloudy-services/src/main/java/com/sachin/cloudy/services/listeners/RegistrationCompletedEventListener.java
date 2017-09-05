package com.sachin.cloudy.services.listeners;

import com.sachin.cloudy.common.logger.InjectLogger;
import com.sachin.cloudy.data.entities.User;
import com.sachin.cloudy.services.events.RegistrationCompletedEvent;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.OTPService;
import com.sachin.cloudy.services.services.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by sachinhooda on 4/9/17.
 */
@Component
public class RegistrationCompletedEventListener implements
        ApplicationListener<RegistrationCompletedEvent> {

  @InjectLogger
  Logger logger;

  @Autowired
  private UserService userService;

  @Autowired
  private OTPService otpService;

  @Override
  public void onApplicationEvent(RegistrationCompletedEvent registrationCompletedEvent) {

    User user = registrationCompletedEvent.getUser();
    try {
      otpService.createVerificationOTP(user);
    } catch (CloudyServiceException cse) {
      logger.error(cse.getMessage(), cse);
    }
  }
}
