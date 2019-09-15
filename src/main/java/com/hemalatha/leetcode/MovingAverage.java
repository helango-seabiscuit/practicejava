package com.hemalatha.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MovingAverage {

	public static void main(String[] args) {
		MovingAverage average = new MovingAverage(3);
		System.out.println(average.next(1));
		System.out.println(average.next(10));
		System.out.println(average.next(3));
		System.out.println(average.next(5));
		System.out.println(String.format("Error happened when trying to log the payment refund event for listenerId %s for transactionId",12));
	}

	/** Initialize your data structure here. */
	private int windowSize;
	private Queue<Integer> queue;
	private int total;
	public MovingAverage(int size) {
        this.windowSize = size;
        this.queue = new LinkedList<Integer>();
	}

	public double next(int val) {
        if(this.queue.size()+1>this.windowSize){
        	total -= this.queue.poll();
		}
		this.queue.offer(val);
        total +=val;
        return total/(double)this.queue.size();
	}
}