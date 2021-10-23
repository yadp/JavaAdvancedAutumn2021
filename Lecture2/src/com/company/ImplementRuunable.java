package com.company;

public class ImplementRuunable implements Runnable{
    @Override
    public void run() {

        System.out.println(Thread.currentThread().toString()+"New Thread");

        for (int i=0;i<10000;i++){
            System.out.println(i);
        }
    }
}
