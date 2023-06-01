package org.mapsa.cretional.factorymethod;

public class SMSNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("SMS");
    }
}
