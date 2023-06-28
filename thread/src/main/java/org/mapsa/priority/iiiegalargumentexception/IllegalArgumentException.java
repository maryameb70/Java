package org.mapsa.priority.iiiegalargumentexception;

public class IllegalArgumentException extends Thread {
    public static void main(String[] args) {
// Now, priority of the main thread is set to 17, which is greater than 10
        Thread.currentThread().setPriority(17);
        System.out.println("Priority of the main thread is : " + Thread.currentThread().getPriority());
    }
}
