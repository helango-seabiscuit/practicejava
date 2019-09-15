package com.hemalatha.IK.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class OddEvenThread {

    private static AtomicInteger counter = new AtomicInteger(1);
    private  static Object obj = new Object();
    public static void main(String[] args) {
        Thread oddThread = new Thread() {
            public void run() {
                    while (counter.intValue() <= 100) {
                        if (counter.intValue() % 2 == 1) {
                            System.out.println(counter.getAndIncrement());
                        }
                        try {
                                Thread.sleep(1000);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        }
                    }
        };

        Thread evenThread = new Thread() {
            public void run() {

                    while (counter.intValue() <= 100) {
                        if (counter.intValue() % 2 == 0) {
                            System.out.println(counter.getAndIncrement());
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            };

        oddThread.start();
        evenThread.start();
    }

}
