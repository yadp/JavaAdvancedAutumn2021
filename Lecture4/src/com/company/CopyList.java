package com.company;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyList {

    public static void main(String[] args) {
        List<String> birds = new CopyOnWriteArrayList<>();
        birds.add("hawk");
        birds.add("hawk");
        birds.add("hawk");
        var iterator = birds.iterator();
        for (String bird : birds)
            birds.remove(bird);
        System.out.print(birds.size());

    }
}
