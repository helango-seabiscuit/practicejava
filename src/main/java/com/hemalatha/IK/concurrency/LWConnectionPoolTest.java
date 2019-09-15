package com.hemalatha.IK.concurrency;


import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class HeavyObjectProcess{

    private  int size;
    HeavyObjectProcess(int size){
        this.size = size;
    }

    public  void runProcess(){
        for(int i=0;i<1000000;i++){

        }
    }
}

class ConnectionPool{

    private  static ConnectionPool instance;
    private final ConcurrentLinkedQueue<HeavyObjectProcess> pool;
    private static  int POOL_SIZE = 5;
    final Lock lock = new ReentrantLock();
    final Condition notFull  = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    private ConnectionPool(){
        pool = new ConcurrentLinkedQueue<HeavyObjectProcess>();
        for(int i=0;i<POOL_SIZE;i++){
            pool.add(new HeavyObjectProcess(5));
        }
    }
    public static ConnectionPool getInstance(){
        if(instance == null){
            synchronized (ConnectionPool.class){
                if(instance == null){
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    public void returnObject(HeavyObjectProcess object)  {
        lock.lock();
        try {
            while (pool.size() == POOL_SIZE) {
                notFull.await();
            }
            pool.add(object);
            System.out.println("Returned ");
            notEmpty.signal();
        }catch (InterruptedException e){
             e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public HeavyObjectProcess  acquireObject() {
        lock.lock();
        HeavyObjectProcess value = null;
        try {
            while (pool.size() == 0) {
                notEmpty.await();
            }
            value = pool.poll();
            System.out.println("Acquired ");
            notFull.signal();

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return value;
    }
}

class HeavyProcessThreads implements Runnable{

      private ConnectionPool pool;
     HeavyProcessThreads(ConnectionPool pool){
         this.pool = pool;
     }
     public void run(){
         HeavyObjectProcess heavyObjectProcess =pool.acquireObject();
         heavyObjectProcess.runProcess();
         pool.returnObject(heavyObjectProcess);

     }
}


public class LWConnectionPoolTest {

    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        HeavyProcessThreads p1 = new HeavyProcessThreads(connectionPool);
        HeavyProcessThreads p2 = new HeavyProcessThreads(connectionPool);
        HeavyProcessThreads p3 = new HeavyProcessThreads(connectionPool);
        HeavyProcessThreads p4 = new HeavyProcessThreads(connectionPool);
        HeavyProcessThreads p5 = new HeavyProcessThreads(connectionPool);
        HeavyProcessThreads p6 = new HeavyProcessThreads(connectionPool);
        HeavyProcessThreads p7 = new HeavyProcessThreads(connectionPool);
        HeavyProcessThreads p8 = new HeavyProcessThreads(connectionPool);
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        executorService.execute(p1);
        executorService.execute(p2);
        executorService.execute(p3);
        executorService.execute(p4);
        executorService.execute(p5);
        executorService.execute(p6);
        executorService.execute(p7);
        executorService.execute(p8);
        executorService.shutdown();

    }
}
