package org.mapsa.interthreadcommunication.exampletwo;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main starts.");
        Scan scan=new Scan();
        Object obj=scan.obj=new Object();
        scan.start();
        synchronized (obj){
            obj.wait();
        }
        System.out.println("Main other jobs");
    }
}
