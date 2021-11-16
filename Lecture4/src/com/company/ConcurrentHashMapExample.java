package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        Map<String,Integer> map = new ConcurrentHashMap<>();
        map.put("string1", 1);
        map.put("string2", 2);
        System.out.println(map.keySet());
        for(String key: map.keySet())
            map.remove(key);
        System.out.println(map.keySet());


    }
}
