package org.mapsa.exampleracecondition;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int x=17;
        Thread t1 = new Thread(new Plus(x));
        t1.start();
        Thread t2=new Thread(new Plus(x));
        t2.start();
    }
}
