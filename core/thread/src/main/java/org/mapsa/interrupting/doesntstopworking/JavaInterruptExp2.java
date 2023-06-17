package org.mapsa.interrupting.doesntstopworking;

public class JavaInterruptExp2 extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("javatpoint");
        } catch (InterruptedException e) {
            System.out.println("Interrupted" + e);
        }
        System.out.println("thread is running...");
    }

    public static void main(String[] args) {
        JavaInterruptExp2 t1=new JavaInterruptExp2();
        JavaInterruptExp2 t2=new JavaInterruptExp2();
        t1.start();
        // interrupt the thread
        t1.interrupt();
    }
}

