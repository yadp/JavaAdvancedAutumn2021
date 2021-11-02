package com.company.problem;

import java.awt.*;
import java.util.concurrent.*;

public class Execute {
    public static void main(String[] args) {
        int n = 9;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable thread1= new CallableSum(1,n/2);
        Callable thread2= new CallableSum(n/2+1,n);
        Future<Integer> feature1 = executorService.submit(thread1);
        Future<Integer> feature2 = executorService.submit(thread2);

        try {
            Integer integer1= feature1.get();
            Integer integer2= feature2.get();

            System.out.println("Print result between "+ 1+ " and "+ n/2 + " = "+ integer1);
            System.out.println("Print result between "+ (n/2+1) + " and "+ n+ " = "+ integer2);

            System.out.println(integer1+ integer2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

    }
}
