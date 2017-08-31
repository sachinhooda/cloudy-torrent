package com.sachin.cloudy.services.services.impl;

import com.sachin.cloudy.data.entities.OTP;
import com.sachin.cloudy.data.repositories.OTPRepository;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by sachinhooda on 30/8/17.
 */
@Service
@Transactional
public class OTPServiceImpl implements OTPService {

    private static final char[] CHARS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static final char[] NUMS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private Random random;

    private Integer length;

    @Autowired
    private OTPRepository otpRepository;


    public OTPServiceImpl() {

        this.length = 4;
        this.random = new SecureRandom();
    }

    @Override
    public String generateOTP() {
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length / 2; i++) {
            stringBuilder.append(CHARS[random.nextInt(CHARS.length)]);
        }
        for (int i = 0; i < length / 2; i++) {
            stringBuilder.append(NUMS[random.nextInt(NUMS.length)]);
        }
        return stringBuilder.toString();
    }

    @Override
    public OTP save(OTP otp) throws CloudyServiceException {
        return null;
    }

    @Override
    public void resendOTP(String token) throws CloudyServiceException {

    }
}
