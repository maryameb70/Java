package org.mapsa.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        long l = System.currentTimeMillis();
        MyTask task = new MyTask();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        Future<String> future1=executorService.submit(task);
//        executorService.shutdown();
        //String s = future1.get();
        // String s = future1.get(1,TimeUnit.SECONDS);
        List<Callable<String>> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            list.add(new MyTask());
        }
//        list.add(new MyTask());
        List<Future<String>> futures = executorService.invokeAll(list);
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        // System.out.println(s);
        System.out.println("Hello world from main");
        Long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}

class MyTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(5000L);
            return "Hello world from Thread";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
