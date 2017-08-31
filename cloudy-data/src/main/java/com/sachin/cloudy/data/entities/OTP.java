package com.sachin.cloudy.data.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sachinhooda on 30/8/17.
 */
@Entity
@Table(name = "VERIFICATION_TOKENS")
public class OTP extends AbstractEntity {

    private static final long serialVersionUID = -8061214795116816929L;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "VERIFIED")
    private boolean verified;

    @Temporal(TemporalType.DATE)
    @Column(name = "EXPIRY_DATE")
    private Date expiryDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "USER_ID")
    private User user;

    public OTP() {
        super();
    }

    public OTP(String token, Date expiryDate, User user) {
        this.token = token;
        this.expiryDate = expiryDate;
        this.user = user;
        this.verified = false;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
