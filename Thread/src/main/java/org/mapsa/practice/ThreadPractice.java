package org.mapsa.practice;

class PrintThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        Thread currentThread = Thread.currentThread();
        System.out.println("Thread-id:" + currentThread.getId());
        System.out.println("Thread-name:" + currentThread.getName());
    }
}

class BankAccount {
    private float balance;
    public void deposit(float amount) {
        synchronized (this) {
            balance += amount;
        }
    }
    public synchronized void withdraw(float amount) {
        balance -= amount;
    }
    public void printBalance(){
        System.out.println(balance);
    }
}

class ThreadBank implements Runnable{
    @Override
    public void run() {
        BankAccount bankAccount=new BankAccount();
        bankAccount.deposit(10);
        bankAccount.withdraw(5);
        bankAccount.printBalance();
    }
}
public class ThreadPractice {
    public static void main(String[] args) {
        //1
        new Thread(new PrintThread()).start();
        for (char c = 'A'; c <= 'Z'; c++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(c);
        }
        Thread currentThread = Thread.currentThread();
        System.out.println("Main-id:" + currentThread.getId());
        System.out.println("Main-name:" + currentThread.getName());

        //2.synchronized??
//        ThreadBank th=new ThreadBank();
//        Thread th1=new Thread(th);
//        Thread th2=new Thread(th);
//        th1.start();
//        th2.start();



    }
}
