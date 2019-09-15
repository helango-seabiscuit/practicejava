package com.hemalatha.IK.concurrency.YanniSolution;

import java.util.concurrent.Semaphore;


public class OddEvenThread {

    private  static  Semaphore odd;
    private  static  Semaphore even;
    private static  int COUNT = 50;

    public  static  void printNum(int n,boolean isEven,Semaphore me,Semaphore other){
        int val = isEven?0:1;

        try {
            while (val <= n) {
                me.acquire();
                System.out.println(Thread.currentThread().getName() + " " + val);
                val += 2;
                other.release();
            }
        }catch ( InterruptedException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        odd = new Semaphore(0);
        even = new Semaphore(1);
        Thread oddThread = new Thread( ()->{printNum(COUNT,false,odd,even);});
        oddThread.start();
        printNum(COUNT,true,even,odd);
    }
}
