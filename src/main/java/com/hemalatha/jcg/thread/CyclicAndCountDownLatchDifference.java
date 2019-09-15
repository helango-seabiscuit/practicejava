package com.hemalatha.jcg.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicAndCountDownLatchDifference {

	public static void main(String[] args) throws InterruptedException {

		//CountDownLatch
//		CountDownLatch countDownLatch = new CountDownLatch(2);
//		Thread t = new Thread(()->{
//			countDownLatch.countDown();
//			countDownLatch.countDown();
//		});
//
//		t.start();
//		countDownLatch.await();
//
//		System.out.println(countDownLatch.getCount());
//
//		ArrayList<String> ls = new ArrayList<>();
//		CountDownLatch countDownLatch2 = new CountDownLatch(7);
//		ExecutorService es = Executors.newFixedThreadPool(20);
//		for (int i = 0; i < 20; i++) {
//			es.execute(() -> {
//				long prevValue = countDownLatch2.getCount();
//				countDownLatch2.countDown();
//				if (countDownLatch2.getCount() != prevValue) {
//					ls.add("Count Updated");
//				}
//			});
//		}
//		es.shutdown();
//
//		System.out.println((ls.size()));

        //CcyclicBarrier
//		CyclicBarrier barrier = new CyclicBarrier(2);
//		Thread tc = new Thread(()->{
//
//			try {
//				barrier.await();
//				barrier.await();
//			} catch (InterruptedException | BrokenBarrierException e) {
//				e.printStackTrace();
//			}
//		});
//
//		tc.start();
//		System.out.println(barrier.getNumberWaiting());
//		System.out.println(barrier.isBroken());

		CyclicBarrier cyclicBarrier = new CyclicBarrier(7);

		List ls2 = new ArrayList<>();
		ExecutorService es = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 21; i++) {
			es.execute(() -> {
				try {
					boolean isless = false;
					if (cyclicBarrier.getNumberWaiting() <= 0) {
						ls2.add("Count Updated");
                        isless = true;
					}

					cyclicBarrier.await();
					if(isless) {
						System.out.println("less :"+cyclicBarrier.getNumberWaiting());
					}
				} catch (InterruptedException | BrokenBarrierException e) {
					// error handling
				}
			});
		}
		es.shutdown();

		System.out.println((ls2.size()));

	}
}
