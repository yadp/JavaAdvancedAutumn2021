package com.company;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Integer> {

    private Integer result;
    public Factorial(Integer result){
        this.result=result;
    }

    @Override
    public Integer call() throws Exception {
        for (int i=result-1;i>0;i--){
            result=result*i;
        }
        return result;
    }
}
