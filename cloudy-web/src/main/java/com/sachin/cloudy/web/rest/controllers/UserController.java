package com.sachin.cloudy.web.rest.controllers;

import com.sachin.cloudy.data.entities.User;
import com.sachin.cloudy.services.commons.dto.UserDTO;
import com.sachin.cloudy.services.events.RegistrationCompletedEvent;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.UserService;
import com.sachin.cloudy.web.constants.CloudyWebConstants.URLS;
import com.sachin.cloudy.web.exception.CloudyRestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * Created by sachinhooda on 18/2/17.
 */
@RestController
@RequestMapping(value = URLS.URL_BASE)
public class UserController {

  private UserService userService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = URLS.URL_USER, method = RequestMethod.POST)
  public UserDTO registerUser(@RequestBody UserDTO userDTO, WebRequest webRequest)
          throws CloudyRestException {

    try {
      User user = UserDTO.fromDTO(null, userDTO);

      user.setPassword(passwordEncoder.encode(user.getPassword()));
      user.setCreatedDate(LocalDateTime.now());
      user = userService.save(user);
      applicationEventPublisher.publishEvent(new RegistrationCompletedEvent(webRequest
              .getContextPath(), webRequest.getLocale(), user));

      return UserDTO.toDTO(user);
    } catch (CloudyServiceException cse) {
      throw new CloudyRestException(cse.getMessage(), cse);
    }


  }
}
