package com.sachin.cloudy.security.dto;

/**
 * Created by sachinhooda on 18/4/17.
 */
public class ErrorDTO {
    private String url;

    private String message;

    public ErrorDTO(String url, String message) {
        super();
        this.url = url;
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
