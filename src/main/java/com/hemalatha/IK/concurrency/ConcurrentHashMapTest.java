package com.hemalatha.IK.concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class LSConcurrentHashMap{


    private final int NUM_LOCKS = 16;
    private Node[] buckets;
    private Object[] locks;
    private int numBuckets;
     LSConcurrentHashMap(int numBuckets){
       this.numBuckets = numBuckets;
         buckets = new Node[numBuckets];
         locks = new Object[NUM_LOCKS];

         for(int i=0;i<NUM_LOCKS;i++){
             locks[i] = new Object();
         }
     }

     public void set(int key,int value){
         int hash = key%numBuckets;
         synchronized (locks[hash%NUM_LOCKS]){
             Node node = buckets[hash];
             Node newNode = new Node(key,value);
             System.out.println("Writing "+key);
             if(node==null){
                 buckets[hash] = newNode;
             }else{
                 while(node.next!=null){
                     node = node.next;
                 }
                 node.next = newNode;
             }
             try {
                 Thread.sleep(1000);
             }catch (InterruptedException e){
                 e.printStackTrace();
             }
         }
     }

     public Integer get(int key){
         int hash = key%numBuckets;
         synchronized (locks[hash%NUM_LOCKS]){
             Node node = buckets[hash];
             while(node!=null){
                 if(node.key==key){
                     System.out.println("Reading  "+key);
                     return node.value;
                 }
                 node = node.next;
             }

         }
         return null;
     }

    static class Node{
        int key;
        int value;
        Node next;
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }


}

public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        LSConcurrentHashMap map = new LSConcurrentHashMap(10);

        Runnable writer = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    map.set(i,i);
                }
            }
        };

        Runnable reader = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                     map.get(i);
                }
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(writer);
        executorService.execute(reader);
        executorService.shutdown();
    }
}
