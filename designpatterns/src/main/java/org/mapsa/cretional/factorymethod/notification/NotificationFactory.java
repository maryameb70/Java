package org.mapsa.cretional.factorymethod.notification;

public class NotificationFactory {
    public static Notification createNotification(NotificationType chanel){
        if(chanel==null){
            return null;
        }
        switch (chanel){
            case SMS:
                return new SMSNotification();
            case EMAIL:
                return new EmailNotification();
            case PUSH:
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown chanel");
        }

    }
}
