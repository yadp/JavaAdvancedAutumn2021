package com.company;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueueExample {

    public static void main(String[] args) {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(31);
        System.out.println(queue.peek());  // 31
        System.out.println(queue.poll());  // 31
    }
}
