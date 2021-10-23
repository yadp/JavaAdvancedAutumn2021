package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        ImplementRuunable implementRuunable= new ImplementRuunable();
        Thread thread = new Thread(implementRuunable);
        thread.start();

        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().toString() + i);
        }
        System.out.println(Thread.currentThread().toString()+ "Main Thread");

    }


    /*
    List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("fish", false,true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));
        System.out.println("All animals that hop:");
        print(animals,a -> a.canHop());
        System.out.println("All swimming animals:");
        print(animals,(Animal b) -> { return  b.canSwim(); });



        List<String> list=new ArrayList<String>();
        list.add("ankit");
        list.add("mayank");
        list.add("irfan");
        list.add("jai");

        list.forEach(
                (n)->System.out.println(n.length())
        );

        Supplier<Animal> random= () -> new Animal("Test", true, true);



     */



    private static void print(List<Animal> animals, CheckProperty checkProperty){
        for (Animal animal:animals){
            if(checkProperty.test(animal)){
                System.out.println(animal.toString());
            }
        }
    }


}




















/*
 public static void main(String[] args) {
        Consumer<String> consumer = x -> System.out.println(x);
        print(consumer, "Hello World");

        Runnable sloth = () -> System.out.println("Hello World");
        Runnable snake = () -> {int i=10; i++;};
        Runnable beaver = () -> {return;};
        Runnable coyote = () -> {};

        sloth.run();
    }
    private static void print(Consumer<String> consumer, String value) {
        consumer.accept(value);
    }
 */

/*
 List<String> list=new ArrayList<String>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");

        list.forEach(
            (n)->System.out.println(n)
        );

 */

/*

public class LambdaExpressionExample9{
    public static void main(String[] args) {

        //Thread Example without lambda
        Runnable r1=new Runnable(){
            public void run(){
                System.out.println("Thread1 is running...");
            }
        };
        Thread t1=new Thread(r1);
        t1.start();
        //Thread Example with lambda
        Runnable r2=()->{
                System.out.println("Thread2 is running...");
        };
        Thread t2=new Thread(r2);
        t2.start();
    }
}
 */
