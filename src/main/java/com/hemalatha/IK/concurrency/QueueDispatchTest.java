package com.hemalatha.IK.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by helangovan on 1/16/17.
 */

interface  QTask{

    static final int FLAGS_NO_LOCK=0;
    static final int FLAGS_FILESYSTEM_LOCK=1;
    static final int FLAGS_DATABASE_LOCK=2;
    static final int FLAGS_MODEL_LOCK=3;
    int getFlags();
    void run();
}

class QueueDispatch{

    private static final int Q_SIZE=4;
    private QTask[] queue;
    private Object[] locks;
    private volatile boolean[] flagLocks;
    private  ReentrantLock qLock=new ReentrantLock();
    private Condition qEmpty= qLock.newCondition();
    private Condition qFull = qLock.newCondition();
    private Object lck = new Object();
    private int count = 0;
    private int conPt=0;
    private int prodPt = 0;
    QueueDispatch(){
        queue = new QTask[Q_SIZE];
        locks = new Object[3];
        flagLocks = new boolean[3];
        for(int i=0;i<3;i++){
           locks[i] = new Object();
            flagLocks[i] = false;
        }
    }

    public void produce(QTask task) {
        qLock.lock();
        try {
            while (count == Q_SIZE) {
                try {
                    qEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            prodPt = prodPt % Q_SIZE;
            queue[prodPt] = task;
            prodPt++;
            count++;
            qFull.signal();
        }finally {
            qLock.unlock();
        }
    }

    public  void consume(){
        qLock.lock();
        try {
            while (count == 0) {
                try {
                    qFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            conPt = conPt % Q_SIZE;
            QTask task = queue[conPt];
            conPt++;
            count--;
            qEmpty.signal();
            int lockNum = task.getFlags();
            if (lockNum == 0) {
                task.run();
            } else {

                if (flagLocks[lockNum - 1]) {
                    try {
                        locks[lockNum - 1].wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    flagLocks[lockNum - 1] = true;
                    synchronized (locks[lockNum - 1]) {
                        task.run();
                    }
                    flagLocks[lockNum - 1] = false;
                }
            }

        }finally {
            qLock.unlock();
        }

    }

}

public class QueueDispatchTest {
    public static void main(String[] args) {
        QTask dbTask = new QTask() {
            @Override
            public int getFlags() {
                return FLAGS_DATABASE_LOCK;
            }

            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("DB Task");
            }
        };

        QTask fileTask = new QTask() {
            @Override
            public int getFlags() {
                return FLAGS_FILESYSTEM_LOCK;
            }

            @Override
            public void run() {
                System.out.println("File Task");
            }
        };

        QTask modelTask = new QTask() {
            @Override
            public int getFlags() {
                return FLAGS_MODEL_LOCK;
            }

            @Override
            public void run() {
                System.out.println("Model Task");
            }
        };
        QTask noTask = new QTask() {
            @Override
            public int getFlags() {
                return FLAGS_NO_LOCK;
            }

            @Override
            public void run() {
                System.out.println("No lock Task");
            }
        };

        QueueDispatch queueDispatch = new QueueDispatch();

        Runnable producers = new Runnable() {
            @Override
            public void run() {
                queueDispatch.produce(dbTask);
                queueDispatch.produce(fileTask);
                queueDispatch.produce(modelTask);
                queueDispatch.produce(dbTask);
                queueDispatch.produce(dbTask);
                queueDispatch.produce(noTask);
            }
        };



        Runnable consumers = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<6;i++){
                    queueDispatch.consume();
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(producers);
        executorService.execute(consumers);



    }
}
