package com.hemalatha.article;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(4);
        for(int i=0;i<4;i++){
            blockingQueue.add(i);
        }

        System.out.println("Adding > 4 items now");
        for(int i=0;i<10;i++){
            System.out.println("Adding " + (i + 4) + "item");
            blockingQueue.put(i);
            //System.out.println(res);
        }
    }
}
