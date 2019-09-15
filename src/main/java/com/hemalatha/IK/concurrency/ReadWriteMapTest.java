package com.hemalatha.IK.concurrency;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by helangovan on 1/14/17.
 */
class ReadWriteMap<K,V> {

    private ReentrantReadWriteLock readWriteLock;
    private final HashMap<K,V> readWriteMap;

    public ReadWriteMap(){
        this.readWriteLock = new ReentrantReadWriteLock();
        this.readWriteMap = new HashMap<K, V>();
    }

    public  void set(K key,V value){
        readWriteLock.writeLock().lock();
        readWriteMap.put(key,value);
        readWriteLock.writeLock().unlock();
    }

    public Optional<V> get(K key){
        V output = null;
        readWriteLock.readLock().lock();
        output = readWriteMap.get(key);
        readWriteLock.readLock().unlock();
        return Optional.ofNullable(output);
    }


}

public class ReadWriteMapTest{
    public static void main(String[] args) {
        ReadWriteMap<Integer,String > readWriteMap = new ReadWriteMap<>();
        Callable writer = new Callable() {
            @Override
            public Object call() throws Exception {
                for(int i=0;i<10;i++) {
                    readWriteMap.set(i, " " + i + " ");
                    System.out.println(Thread.currentThread().getName()+"--- Write "+i);
                }
                return true;
            }
        };

        Callable reader = new Callable() {
            @Override
            public Object call() throws Exception {
                for(int i=0;i<5;i++) {
                    System.out.println(Thread.currentThread().getName()+ "-- "+ readWriteMap.get(i).get());
                }
                return true;
            }
        };


        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(writer);

        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        executorService2.submit(reader);

        ExecutorService executorService3 = Executors.newFixedThreadPool(2);
        executorService3.submit(reader);

        executorService.shutdown();
        executorService2.shutdown();
        executorService3.shutdown();
        try{
            executorService.awaitTermination(30, TimeUnit.SECONDS);
            executorService2.awaitTermination(30, TimeUnit.SECONDS);
            executorService3.awaitTermination(30, TimeUnit.SECONDS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}


