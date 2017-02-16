package com.sachin.cloudy.web.exception;

import com.sachin.cloudy.common.exception.CloudyException;

/**
 * Created by sachinhooda on 16/2/17.
 */
public class CloudyRestException extends CloudyException {
    public CloudyRestException() {
    }

    public CloudyRestException(String message) {
        super(message);
    }

    public CloudyRestException(String message, Throwable cause) {
        super(message, cause);
    }

    public CloudyRestException(Throwable cause) {
        super(cause);
    }

    public CloudyRestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
