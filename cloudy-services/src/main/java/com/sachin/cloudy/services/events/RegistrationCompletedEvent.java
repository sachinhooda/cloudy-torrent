package com.sachin.cloudy.services.events;

import com.sachin.cloudy.data.entities.User;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

/**
 * Created by sachinhooda on 4/9/17.
 */
public class RegistrationCompletedEvent extends ApplicationEvent {

  private static final long serialVersionUID = -8555016087295777505L;
  private final String appURL;
  private final Locale locale;
  private final User user;

  public RegistrationCompletedEvent(String appURL, Locale locale, User user) {
    super(user);
    this.appURL = appURL;
    this.locale = locale;
    this.user = user;
  }

  public String getAppURL() {
    return appURL;
  }

  public Locale getLocale() {
    return locale;
  }

  public User getUser() {
    return user;
  }
}
