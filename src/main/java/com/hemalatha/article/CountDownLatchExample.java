package com.hemalatha.article;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

    public static void main(String[] args) {

        String s = "Now playing Frozen Medley: Do You Wanna Build a Snowman? / For the First Time in Forever / Love Is an Open Door / Let It Go by Anthem Lights";
        System.out.println(s.length());
        System.out.println(s.substring(0,41));
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Runnable r = () -> {
            try {
                countDownLatch.countDown();
                System.out.println("count down done");
            } catch (Exception e){
                e.printStackTrace();
            }
        };

        Runnable q = () -> {
            try{
                Thread.sleep(3000);
                countDownLatch.await();
                System.out.println("Task completed");
            }catch (Exception e){
                e.printStackTrace();;
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(r);
        executorService.submit(r);
      //  executorService.submit(r);
        executorService.submit(q);

    }


}
