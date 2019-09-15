package com.hemalatha.IK.concurrency;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyTimer{

    private List<Callable> tasks;
    private long timeDelay;
    ExecutorService executorService;
    private List<Future> result;
    private static  final String DONE="DONE";
    private static  final String CANCELLED="CANCELLED";
    private static  final String NOT_SCHEDULED="NOT SCHEDULED";
    private static  final String RUNNING="RUNNING";
    MyTimer(List<Callable> r, long delayTimeInMilliSeconds){
       this.tasks = r;
        this.timeDelay = delayTimeInMilliSeconds;
        //this cached pool will take care of creating threads as needed and destroy unnecessary threads
        executorService = Executors.newCachedThreadPool();
        result = new ArrayList<>();
    }

    public void schedule(){

        try {
            Thread.sleep(timeDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<tasks.size();i++){
              Future res = executorService.submit(tasks.get(i));
              result.add(res);
              try {
                  Thread.sleep(timeDelay);
              }catch (InterruptedException e){
                  e.printStackTrace();
              }
        }

    }

    public boolean cancel(int index){
        if(result.get(index)==null || result.get(index).isCancelled()){
            return false;
        }
        return result.get(index).cancel(true);
    }

    public String getStatus(int index){
        String status=RUNNING;
        if(result.get(index)==null){
            status = NOT_SCHEDULED;
        }
        else if(result.get(index).isDone()){
            status = DONE;
        }else if (result.get(index).isCancelled()){
            status = CANCELLED;
        }
        return status;

    }

}

public class MyTimerTest {

    public static void main(String[] args) {
        List<Callable> callableList = new ArrayList<>();
        callableList.add(new Task("T1"));
        callableList.add(new Task("T2"));
        callableList.add(new Task("T3"));
        callableList.add(new Task("T4"));
        callableList.add(new Task("T5"));
        MyTimer timer = new MyTimer(callableList,2000);
        timer.schedule();
    }
}

class Task implements  Callable{

    private String name;
    Task(String name){
        this.name = name;
    }
    public Boolean call() {
        System.out.println(this.name+"--"+Thread.currentThread().getName());
        for(int i=0;i<10;i++){try {
            Thread.sleep(300);
        }catch (InterruptedException e){
            e.printStackTrace();
        }}
        System.out.println("Done "+this.name);
        return true;
    }
}
