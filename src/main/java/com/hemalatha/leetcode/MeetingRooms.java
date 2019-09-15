package com.hemalatha.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

	public static void main(String[] args) {
		MeetingRooms rooms = new MeetingRooms();
		System.out.println(rooms.minMeetingRooms(new Interval[]{new Interval(2,5),new Interval(8,9),new Interval(8,9)}));
		PriorityQueue<Integer> p = new PriorityQueue<>();
		p.offer(4);
		p.offer(4);
		p.offer(4);
		p.offer(4);
		p.offer(4);
		System.out.println(p.size());
	}


	public int minMeetingRooms(Interval[] intervals){
		// Check for the base case. If there are no intervals, return 0
		if (intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, (i1,i2)->{
			return Integer.compare(i1.start,i2.start);
		});

		PriorityQueue<Integer> q = new PriorityQueue<>((i1,i2)->{
			return Integer.compare(i1,i2);
		});

		for(Interval i:intervals){

			if(!q.isEmpty() && q.peek() <= i.start){
				q.poll();
			}
			q.offer(i.end);
		}

		return q.size();
	}
}


