package org.mapsa.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestRunnable {
    public static void main(String[] args) throws InterruptedException {
        Runnable target=new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000L);
                    System.out.println("Hello world from Thread");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(target);
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("Hello world from main");

    }
}
