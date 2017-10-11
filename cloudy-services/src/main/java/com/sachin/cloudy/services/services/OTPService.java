package com.sachin.cloudy.services.services;

import com.sachin.cloudy.data.entities.OTP;
import com.sachin.cloudy.data.entities.User;
import com.sachin.cloudy.services.exception.CloudyServiceException;

/**
 * Created by sachinhooda on 30/8/17.
 */
public interface OTPService {

    String generateOTP();

    OTP save(OTP otp) throws CloudyServiceException;

    void resendOTP(String token) throws CloudyServiceException;

    String createVerificationOTP(User user) throws CloudyServiceException;
}
