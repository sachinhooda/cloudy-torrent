package com.sachin.cloudy.services.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sachinhooda on 4/9/17.
 */
public class OTPUtils {

  public static Date calculateExpiryDate(int expiryTimeInMinutes) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Timestamp(calendar.getTime().getTime()));
    calendar.add(12, expiryTimeInMinutes);
    return new Date(calendar.getTime().getTime());

  }
}
