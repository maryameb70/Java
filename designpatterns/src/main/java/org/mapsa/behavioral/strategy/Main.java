package org.mapsa.behavioral.strategy;

import org.mapsa.cretional.factorymethod.notification.Notification;
import org.mapsa.cretional.factorymethod.notification.NotificationFactory;
import org.mapsa.cretional.factorymethod.notification.NotificationType;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<LoggerTypes, Logger> loggerMap = new HashMap<>();
        loggerMap.put(LoggerTypes.FILE, new FileLogger());
        loggerMap.put(LoggerTypes.MONGO, new MongoLogger());
        Notification notification = NotificationFactory.createNotification(NotificationType.SMS);
        loggerMap.get(LoggerTypes.FILE).log(notification);
    }
}
