package org.mapsa.interthreadcommunication.exampletwo;

public class Scan extends Thread{
    public Object obj;
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("scan");
        synchronized (obj){
            obj.notify();
        }
        System.out.println("Scan other jobs");
    }
}
