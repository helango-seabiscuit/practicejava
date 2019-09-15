package com.hemalatha.jcg.thread;

import javax.crypto.KeyGenerator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadStarter {


	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
      try {

	  //service.scheduleWithFixedDelay(new SimpleThread(),0,1, TimeUnit.SECONDS);
	  Future<?> res = service.submit(new SimpleThread());
	  System.out.println("after ");
	  if (res.get() == null) {
		  System.out.println("success ");
		  System.out.println(res.get());
	  }

  }catch (Exception e){
  	e.printStackTrace();
  }
		service.shutdown();
	}
}
