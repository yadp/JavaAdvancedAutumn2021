package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static AtomicInteger s1 = new AtomicInteger(0); // w1
    private static int s2 = 0;

    private static void countSheep() throws InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor(); // w2
            for (int i = 0; i < 100; i++)
                service.execute(() -> {
                    s1.getAndIncrement(); s2++; }); // w3
            Thread.sleep(100);
            System.out.println(s1 + " " + s2);
        } finally {
            if(service != null) service.shutdown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> favNumbers =
                new CopyOnWriteArrayList<>(List.of(4,3,42));
        for(var n: favNumbers) {
            System.out.print(n + " ");
            favNumbers.add(9);
        }
        System.out.println();
        System.out.println(favNumbers);
        System.out.println("Size: " + favNumbers.size());


        //countSheep();
	// write your code here
       /* var foodData = new ConcurrentHashMap<String, Integer>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for(String key: foodData.keySet())
            foodData.remove(key);*/

       /* List<String> birds = new CopyOnWriteArrayList<>();
        birds.add("hawk");
        birds.add("hawk");
        birds.add("hawk");
        var iterator = birds.iterator();
        while(iterator.hasNext()) {
            iterator.next();
       iterator.remove();
        }*/




        /*for (String bird : birds)
            birds.remove(bird);
        System.out.print(birds.size()); // 0*/
    }
}
