package com.hemalatha.jcg.thread;

import org.joda.time.DateTime;

public class SimpleThread implements Runnable {
	@Override
	public void run() {
		//try {
			System.out.println("starting..."+Thread.currentThread().getName()+"---"+ DateTime.now());
			//Thread.sleep(3000);
			System.out.println("Ending..."+Thread.currentThread().getName()+"---"+ DateTime.now());
		//	throw  new RuntimeException();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}catch (Exception e){
//
//		}
	}
}
