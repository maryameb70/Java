package org.mapsa.behavioral.strategy;

public class FileLogger implements Logger {
    @Override
    public void log(Object o) {
        System.out.println("Logged on File");
    }
}
