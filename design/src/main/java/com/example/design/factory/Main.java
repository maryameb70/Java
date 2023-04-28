package com.example.design.factory;

public class Main {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.CreateNotification(NotificationType.EMAIL);
        notification.notifyUser();
    }
}
