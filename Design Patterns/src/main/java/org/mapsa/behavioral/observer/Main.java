package org.mapsa.behavioral.observer;

public class Main {
    public static void main(String[] args) {
        NewsAgency observable = new NewsAgency();
        NewsChannel observer = new NewsChannel();

        observable.addObserver(observer);
        observable.setNews("news");
        assertEquals(observer.getNews(), "news");
    }

    private static void assertEquals(String news, String news1) {
    }
}
