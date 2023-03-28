package org.mapsa.behavioral.strategy;

public class MongoLogger implements Logger {
    @Override
    public void log(Object o) {
        System.out.println("logged on Mongo");
    }
}
