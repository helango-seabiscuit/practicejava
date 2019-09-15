package com.hemalatha.IK.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


class ServletRequest{

    private String name;
    ServletRequest(String name){
       this.name = name;
    }

    public String getName(){
        return  this.name;
    }
    public String toString(){
        return this.name;
    }
}

class ServletResponse{
    private String name;
    ServletResponse(String name){
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}

class TestHttpServlet  {

     ExecutorService executorService;
     private static  int NUM_THREADS = 2;
    TestHttpServlet(){
        executorService = Executors.newFixedThreadPool(NUM_THREADS);
    }
    public ServletResponse get(ServletRequest servletRequest){
       Callable handler = new Callable() {
           @Override
           public ServletResponse call() {
               //process incoming request
               System.out.println("Processing req "+servletRequest);
               //if we handle this in another thread or make each TestHttpServlet  is handled by
               // separate threads then response can be concurrent
               return handleResponse(servletRequest);
           }
       };

        Future<ServletResponse> response = executorService.submit(handler);
        try {
            return response.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;//handle Error
    }

    public synchronized  ServletResponse handleResponse(ServletRequest request){ //make the response synchronous
        ServletResponse response = new ServletResponse(request.getName());
        System.out.println("Sending Response "+response);
        return  response;
    }

}

public class RequestDispatcherClient {

    public static void main(String[] args) {
        TestHttpServlet httpServlet = new TestHttpServlet();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                ServletRequest request = new ServletRequest(Thread.currentThread().getName());
                ServletResponse response = httpServlet.get(request);

            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(r);
        executorService.execute(r);
        executorService.execute(r);
        executorService.shutdown();
        try {
            executorService.awaitTermination(2,TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
