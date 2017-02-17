package com.sachin.cloudy.common.exception;

/**
 * Created by sachinhooda on 16/2/17.
 */
public class CloudyException extends Exception {

  public CloudyException() {}

  public CloudyException(String message) {
    super(message);
  }

  public CloudyException(String message, Throwable cause) {
    super(message, cause);
  }

  public CloudyException(Throwable cause) {
    super(cause);
  }

  public CloudyException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
