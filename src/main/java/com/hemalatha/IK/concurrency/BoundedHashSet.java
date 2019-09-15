package com.hemalatha.IK.concurrency;


import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class HashSemaphore {

    private final int locks;
    private int count;

    public HashSemaphore(int limit){
       this.locks = limit;
        this.count = 0;
    }

    public synchronized void acquire() throws InterruptedException {
        while(this.locks == count){
            this.wait();
        }
        count++;
        this.notify();
    }

    public synchronized void release() throws InterruptedException{
        while(this.count ==0){
            this.wait();
        }
        count--;
        this.notify();
    }

}

public class BoundedHashSet {

    private HashSet<Integer> hashSet;
    private  int size;
    private HashSemaphore semaphore;

    public BoundedHashSet (int size){
        this.size = size;
        semaphore = new HashSemaphore(size);
        hashSet = new HashSet<>();
    }

    public void set(int value)  {
        try {
                semaphore.acquire();
                System.out.println("Adding value " + value);
                hashSet.add(value);

        }catch (InterruptedException e){
             e.printStackTrace();
        }
    }

    public boolean remove(int value) {
        boolean isRemoved = Boolean.FALSE;
        try {
                semaphore.release();
                System.out.println("Removing value " + value);
                isRemoved = hashSet.remove(value);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return  isRemoved;
    }

    public static void main(String[] args) {
        BoundedHashSet hashSet = new BoundedHashSet(2);

        Callable writeThread = new Callable(){

            public Boolean call() {
                for(int i=0;i<10;i++){
                    hashSet.set(i);
                }
                return  true;
            }
        };

        Callable readThread = new Callable(){
            @Override
            public Boolean call() {
                for(int i=0;i<4;i++){
                    hashSet.remove(i);
                }
                return true;
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future future1 = executorService.submit(writeThread);

        ExecutorService executorService2 = Executors.newFixedThreadPool(5);
        Future future2 = executorService2.submit(readThread);

        if(future1.isDone()){
            executorService.shutdown();
        }
        if(future2.isDone()) {
            executorService2.shutdown();
        }
    }




}
