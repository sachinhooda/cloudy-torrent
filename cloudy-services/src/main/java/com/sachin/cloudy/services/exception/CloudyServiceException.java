package com.sachin.cloudy.services.exception;

import com.sachin.cloudy.common.exception.CloudyException;

/**
 * Created by sachinhooda on 16/2/17.
 */
public class CloudyServiceException extends CloudyException {
  public CloudyServiceException() {}

  public CloudyServiceException(String message) {
    super(message);
  }

  public CloudyServiceException(String message, Throwable cause) {
    super(message, cause);
  }

  public CloudyServiceException(Throwable cause) {
    super(cause);
  }

  public CloudyServiceException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
