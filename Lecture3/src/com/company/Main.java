package com.company;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
	// write your code here
        ExecutorService executorService= null;
        try {
            executorService= Executors.newFixedThreadPool(5);
            Callable<Integer> factorial = new Factorial(5);
            Future<Integer> factorialResult = executorService.submit(factorial);
            System.out.println(factorialResult.get(10,TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
             executorService.shutdown();
        }
    }
}
