package com.hemalatha.leetcode;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2)-> n1-n2);

		int[] nums = new int[]{4,8,6,1,2,9,7};

		for(int n:nums){
			pq.add(n);

			if(pq.size() > 4){
				pq.poll();
			}
		}

		System.out.println(pq.poll());
	}
}
