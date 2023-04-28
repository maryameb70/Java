package com.example.design.factory;

public class SmsNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("sms");
    }
}
