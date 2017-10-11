package com.sachin.cloudy.services.services.impl;

import com.sachin.cloudy.common.logger.InjectLogger;
import com.sachin.cloudy.data.entities.OTP;
import com.sachin.cloudy.data.entities.User;
import com.sachin.cloudy.data.repositories.OTPRepository;
import com.sachin.cloudy.services.constants.OTPConstants;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.OTPService;
import com.sachin.cloudy.services.utils.OTPUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

/**
 * This Service Class acts as a Layer between Repository and Controller. It contains the methods for
 * generating, verifying and resending the OTP . Created by sachinhooda on 30/8/17.
 */
@Service
@Transactional
public class OTPServiceImpl implements OTPService {

    private static final char[] CHARS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static final char[] NUMS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    @InjectLogger
    Logger logger;
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
        try {
            return otpRepository.save(otp);
        } catch (Exception e) {
            throw new CloudyServiceException(e.getMessage(), e);
        }

    }

    @Override
    public void resendOTP(String token) throws CloudyServiceException {
        // TODO

    }

    @Override
    public String createVerificationOTP(User user) throws CloudyServiceException {
        String token = this.generateOTP();
        logger.info("OTP : " + token);
        Date expiryDate = OTPUtils.calculateExpiryDate(OTPConstants.EXPIRATION_TIME_IN_MINUTES);
        OTP otp = new OTP(token, expiryDate, user);
        this.save(otp);
        return token;
    }
}
