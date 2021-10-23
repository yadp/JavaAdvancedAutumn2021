package com.company;

public class Singleton {

    private static Singleton onlySingleton;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(onlySingleton == null){
            onlySingleton= new Singleton();
        }
        return onlySingleton;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;

}
