package com.example.design.factory;

public class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("email");
    }
}
