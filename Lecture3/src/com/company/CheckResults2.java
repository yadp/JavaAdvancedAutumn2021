package com.company;

import java.util.concurrent.*;
public class CheckResults2 {
    private static int counter = 0;
    public static void main(String[] unused) throws Exception {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Callable<Integer> counterCallable= new CounterCallable();
            Future<Integer> result = service.submit(counterCallable);
            System.out.println(result.get(1, TimeUnit.MILLISECONDS));
            System.out.println("Reached!");

        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if(service != null) service.shutdown();
        } } }
