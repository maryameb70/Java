package org.mapsa.examplethread;

public class Threading {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 =new Thread(new R());
        t1.start();
        t1.join();
        new T().start();
        new Thread(new R()).start();
        new T().start();
        for (char c = 'a'; c < 'z'; c++) {
            System.out.println(c);
        }
    }
}
