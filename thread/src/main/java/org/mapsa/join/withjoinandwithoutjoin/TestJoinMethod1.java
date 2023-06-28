package org.mapsa.join.withjoinandwithoutjoin;

public class TestJoinMethod1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoinMethod1 th1 = new TestJoinMethod1();
        TestJoinMethod1 th2=new TestJoinMethod1();
        TestJoinMethod1 th3=new TestJoinMethod1();
        th1.start();
        th1.join();
        th2.start();
        th3.start();
    }
}
