package org.mapsa.interrupting.behavesnormally;

public class JavaInterruptExp3 extends Thread{
    @Override
    public void run() {
        for(int i=1; i<=5; i++)
            System.out.println(i);
    }

    public static void main(String[] args) {
        JavaInterruptExp3 t1=new JavaInterruptExp3();
        t1.start();
        t1.interrupt();
    }
}
