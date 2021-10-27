package com.company;

public class Task1 implements Runnable {

    public static int count=0;
    @Override
    public void run() {
        System.out.println("Printing zoo inventory");
    }
}
