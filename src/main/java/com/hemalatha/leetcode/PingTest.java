package com.hemalatha.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PingTest {


	private static Queue<Long> timeSlots = new LinkedList<>();
	public static void main(String[] args) {
         int [] arr = new int[]{1,3,1000,3000,4000,8000,8900,9600};
         for(int a:arr) {
			 System.out.println(ping(a));
		 }
	}

	public static int ping(long t) {
		timeSlots.add(t);

		while (!timeSlots.isEmpty() && timeSlots.peek() < t - 3000) {
			timeSlots.remove();
		}
		return timeSlots.size();
	}
}
