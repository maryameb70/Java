package org.mapsa.cretional.factorymethod;

public class EmailNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Email");
    }
}
