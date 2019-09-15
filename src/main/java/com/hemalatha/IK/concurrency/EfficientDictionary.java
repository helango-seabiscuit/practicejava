package com.hemalatha.IK.concurrency;


import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//Using ReentrantReadWriteLock we can have many readers and only one exclusive writer

public class EfficientDictionary {

    private static HashMap<String,String> dictionary;
    private int numReaders;
    private int numEditors;
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static {
        dictionary = new HashMap<>();
        dictionary.put("giant","big");
    }

    public void addOrEdit(String key,String meaning){
        readWriteLock.writeLock().lock();
        numEditors++;
        dictionary.computeIfPresent(key,(k,v)->v+","+meaning);
        dictionary.computeIfAbsent(key,(v)->  v);
        System.out.println("There are "+numEditors+" editors");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        readWriteLock.writeLock().unlock();
        numEditors--;
    }

    public String getMeaning(String key){
        String meaning;
        readWriteLock.readLock().lock();
        numReaders++;
        meaning = dictionary.get(key);
        System.out.println("There are "+numReaders+" readers");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        readWriteLock.readLock().unlock();
        numReaders--;
        return meaning;

    }

    public static void main(String[] args) {
      EfficientDictionary efficientDictionary = new EfficientDictionary();
        Runnable t = ()->{efficientDictionary.getMeaning("giant");};
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();

        Runnable tr = ()->{efficientDictionary.addOrEdit("beware","careful");};
        Thread t4 = new Thread(tr);
        Thread t5 = new Thread(tr);
        t4.start();
        t5.start();
    }
}
