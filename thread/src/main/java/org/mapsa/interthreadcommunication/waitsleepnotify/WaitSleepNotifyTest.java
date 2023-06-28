package org.mapsa.interthreadcommunication.waitsleepnotify;

public class WaitSleepNotifyTest {
    public static void main(String[] args) {
        Message msg=new Message("thread");
        new Thread(new ThreadOne(msg)).start();
        new Thread(new ThreadTwo(msg)).start();
        new Thread(new ThreadThree(msg)).start();
    }
}
