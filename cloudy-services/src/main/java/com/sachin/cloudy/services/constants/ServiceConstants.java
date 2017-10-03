package com.sachin.cloudy.services.constants;

/**
 * Created by sachinhooda on 3/10/17.
 */
public interface ServiceConstants {

    public enum NotificationTemplate {
        NOTIFICATION_USER_REGISTERED, NOTIFICATION_DOWNLOAD_FINISHED, NOTIFICATION_DOWNLOAD_STARTED, NOTIFICATION_TORRENT_STARTED
    }

    public enum NotificationTargetType {
        EMAIL, SMS
    }
}
