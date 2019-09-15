package com.hemalatha.IK.concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class LockOrderDeadLock{

    private Object objA;
    private Object objB;
    private static int NUM_ITEMS = 1000000;


    LockOrderDeadLock(){
        objA = new Object();
        objB = new Object();
    }
    public void processA(){
        synchronized (objA){
            System.out.println(Thread.currentThread().getName()+" holds ObjA");
            try {
                Thread.sleep(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            synchronized (objB){
                System.out.println(Thread.currentThread().getName()+" holds ObjB");
                for (int i=0;i<NUM_ITEMS;i++){
                }
            }
        }
    }


    //change this order by acquiring objA and then objB will not cause deadlock
    public void processB(){
        synchronized (objA){
            
            System.out.println(Thread.currentThread().getName()+" holds ObjA");
            try {
                Thread.sleep(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            synchronized (objB){
                System.out.println(Thread.currentThread().getName()+" holds ObjB");
                for (int i=0;i<NUM_ITEMS;i++){

                }
            }
        }
    }


}

public class LockOrderDeadlockTest {

    public static void main(String[] args) {
        LockOrderDeadLock lockOrderDeadLock = new LockOrderDeadLock();


        Runnable objA = new Runnable() {
            @Override
            public void run() {
                lockOrderDeadLock.processA();
            }
        };

        Runnable objB = new Runnable() {
            @Override
            public void run() {
                lockOrderDeadLock.processB();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(objA);
        executorService.execute(objB);
        executorService.shutdown();
        try{
            executorService.awaitTermination(30, TimeUnit.SECONDS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
