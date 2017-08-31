package com.sachin.cloudy.services.commons.dto;

/**
 * Created by sachinhooda on 31/8/17.
 */
public class MessageDTO {
    private String message;

    public MessageDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
