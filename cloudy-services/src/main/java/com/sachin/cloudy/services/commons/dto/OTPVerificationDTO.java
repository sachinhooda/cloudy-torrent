package com.sachin.cloudy.services.commons.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by sachinhooda on 31/8/17.
 */
public class OTPVerificationDTO {


    @NotNull
    @NotBlank
    @NotEmpty
    private String email;


    @NotNull
    @NotBlank
    @NotEmpty
    private String otp;

    public OTPVerificationDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
