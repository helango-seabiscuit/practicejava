package com.hemalatha.IK.concurrency;


import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class LegacyReentrantLock {


    private Object locker = new Object();
    private  boolean isAcquired = false;
    ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    private ConcurrentLinkedQueue<Thread> concurrentLinkedQueue = new ConcurrentLinkedQueue();
    private Thread currentThread;

    public  void acquire(){
        synchronized (locker) {
            if (!isAcquired) {
                isAcquired = true;
                currentThread = Thread.currentThread();
            } else {
                if (currentThread != Thread.currentThread())
                    concurrentLinkedQueue.add(Thread.currentThread());
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public  void release(){
      synchronized (locker) {
          if (currentThread == Thread.currentThread()) {
              isAcquired = false;
              currentThread = null;
          }
          if (concurrentLinkedQueue.size() > 0) {
              currentThread = concurrentLinkedQueue.poll();
              currentThread.notify();
              isAcquired = true;
          }
      }
    }
}


public class LegacyReentrantLockTest {

    private static  LegacyReentrantLock lock = new LegacyReentrantLock();

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                lock.acquire();
                for(int i=0;i<10000;i++){
                    System.out.println(Thread.currentThread().getName()+" --- "+i);
                }
                lock.release();
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                lock.acquire();
                for(int i=0;i<10000;i++){
                    System.out.println(Thread.currentThread().getName()+" --- "+i);
                }
                lock.release();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(runnable);
        executorService.execute(runnable2);
    }

}
