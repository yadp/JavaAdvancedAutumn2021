package com.company;

import jdk.jshell.spi.ExecutionControl;

import java.util.concurrent.*;
class Food {}
class Water {}
public class Fox {
    public void eatAndDrink(Food food, Water water,String name) {
        synchronized(food) {
            System.out.println(name+" Got Food!");
            move();
            synchronized(water) {
                System.out.println(name+ " Got Water!");
            }
        }
    }

    @Deprecated
    public void drinkAndEat(Food food, Water water) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("");
    }
    public void move() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // Handle exception
        }
    }
    public static void main(String[] args) {
        // Create participants and resources
        Fox foxy = new Fox();
        Fox tails = new Fox();
        Food food = new Food();
        Water water = new Water();
        //Water water1= new Water();
        // Process data
        ExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> foxy.eatAndDrink(food,water,"Foxy"));
            service.submit(() -> tails.eatAndDrink(food,water,"Tails"));
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
