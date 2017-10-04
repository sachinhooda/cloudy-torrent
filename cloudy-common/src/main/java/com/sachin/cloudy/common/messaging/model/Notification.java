package com.sachin.cloudy.common.messaging.model;

/**
 * Created by sachinhooda on 3/10/17.
 */
public class Notification {
    private String notificationType;
    private String subject;
    private String to;
    private String from;
    private String body;

    public Notification() {
    }

    public Notification(String notificationType, String subject, String to, String from, String body) {
        this.notificationType = notificationType;
        this.subject = subject;
        this.to = to;
        this.from = from;
        this.body = body;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
