package org.mapsa.cretional.factorymethod;

public class PushNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Push");
    }
}
