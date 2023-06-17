package org.mapsa.interrupting.stopworking;

public class JavaInterruptExp1 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("javatpoint");
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted..." + e);
        }
    }

    public static void main(String[] args) {
        JavaInterruptExp1 th1 = new JavaInterruptExp1();
        th1.start();
        try {
            th1.interrupt();
        } catch (Exception e) {
            System.out.println("Exception handled " + e);
        }
    }
}

