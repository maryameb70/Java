package com.example.design.factory;

public class NotificationFactory {
    public static Notification CreateNotification(NotificationType type){
        if(type==null){
            return null;
        }
        switch (type) {
            case SMS -> {
                return new SmsNotification();
            }
            case EMAIL -> {
                return new EmailNotification();
            }
            default -> throw new IllegalArgumentException("type not found");
        }
    }
}
