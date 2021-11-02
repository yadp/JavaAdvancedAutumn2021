package com.company.problem;

import java.util.concurrent.Callable;

public class CallableSum implements Callable<Integer> {
    private int a;
    private int b;

    public CallableSum(int a, int b){
        this.a=a;
        this.b=b;
    }

    @Override
    public Integer call() throws Exception {
        Integer sum = 0;

        for (int i=a;i<=b;i++){
            sum+=i;
        }
        return sum;
    }
}
