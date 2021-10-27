package com.company;

public class Task2 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 3; i++)
            System.out.println("Printing record: "+i);
    }
}
