package com.company;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager {
    public AtomicInteger getSheepCount() {
        return sheepCount;
    }

    private AtomicInteger sheepCount = new AtomicInteger(0);
    private void incrementAndReport() {


        synchronized (this) {
            sheepCount.incrementAndGet();
            System.out.print((sheepCount) + " ");
        }

    }


    public static void main(String[] args) {
        ExecutorService service = null;
        SheepManager manager = new SheepManager();
        try {
            service = Executors.newFixedThreadPool(20);

            for(int i = 0; i < 10; i++)

                    service.submit(() -> manager.incrementAndReport());

        } finally {
            if(service != null) service.shutdown();
        }
    }
}
