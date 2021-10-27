package com.company;

import java.util.concurrent.Callable;

public class CounterCallable implements Callable<Integer> {
    private int counter;
    public CounterCallable(){
        counter=0;
    }
    @Override
    public Integer call() throws Exception {
        for(int i = 0; i < 50000; i++)
            counter++;
        return counter;
    }
}
