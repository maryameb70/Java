package org.mapsa.cretional.factorymethod.notification;

public class EmailNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Email");
    }
}
