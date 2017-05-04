package com.sachin.cloudy.services.services.impl;

import com.sachin.cloudy.data.entities.User;
import com.sachin.cloudy.data.repositories.UserRepository;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sachinhooda on 25/2/17.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User save(User user) throws CloudyServiceException {

    user = userRepository.save(user);
    return user;
  }
}
