package com.company.problem;

import java.util.List;
import java.util.concurrent.Callable;

public class CallableSum implements Callable<Integer> {
    private int a;
    private int b;
    private List<Integer> listOfNumbers;

    public CallableSum(int a, int b, List<Integer> list){
        this.a=a;
        this.b=b;
        this.listOfNumbers= list;
    }

    @Override
    public Integer call() throws Exception {
        Integer sum = 0;

        for (int i=a;i<=b;i++){
            sum+=i;
            listOfNumbers.add(i);
        }
        return sum;
    }
}
