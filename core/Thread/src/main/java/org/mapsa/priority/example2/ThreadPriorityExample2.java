package org.mapsa.priority.example2;

public class ThreadPriorityExample2 extends Thread {
    @Override
    public void run() {
        System.out.println("Inside the run() method");
    }

    public static void main(String[] args) {
        // Now, priority of the main thread is set to 7
        Thread.currentThread().setPriority(7);
        System.out.println("Priority of the main thread is : " + Thread.currentThread().getPriority());

        ThreadPriorityExample2 th1 = new ThreadPriorityExample2();

        // th1 thread is the child of the main thread
        // therefore, the th1 thread also gets the priority 7
        System.out.println("Priority of the thread th1 is : " + th1.getPriority());
    }
}
