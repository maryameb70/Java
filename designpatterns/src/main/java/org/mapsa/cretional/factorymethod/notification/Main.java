package org.mapsa.cretional.factorymethod.notification;

public class Main {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.createNotification(NotificationType.SMS);
        notification.notifyUser();
    }
}
