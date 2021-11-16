package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionSyncExample {
    public static void main(String[] args) {
        var foodData = new HashMap<String, Object>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);





        var synFoodData = Collections.synchronizedMap(foodData);
        for(String key: synFoodData.keySet())
            synFoodData.remove(key);
    }
}
