package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IntervalMerge {


	public static void main(String[] args) {
//[[1,3],[2,6],[8,10],[15,18]]
		Interval i1 = new Interval(1,3);
		Interval i2 = new Interval(2,6);
		Interval i3 = new Interval(8,10);
		Interval i4 = new Interval(15,18);
		List<Interval> list = new ArrayList<>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		merge(list).forEach(i-> System.out.println(i.start+","+i.end));
		//[[1,4],[4,5]]
		Interval i5 = new Interval(1,4);
		Interval i6 = new Interval(0,4);
		List<Interval> list2 = new ArrayList<>();
		list2.add(i5);
		list2.add(i6);
		System.out.println("List 2");
		merge(list2).forEach(i-> System.out.println(i.start+","+i.end));
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		intervals.add(newInterval);
		return merge(intervals);

	}

	public static List<Interval> merge(List<Interval> intervals) {

		if(intervals.size() <=1){
			return intervals;
		}

		Collections.sort(intervals, (i1,i2)->  Integer.valueOf(i1.start).compareTo(i2.start));
//		Collections.sort(intervals, (i1,i2)->  Integer.compare(i1.start,i2.start));

		int curr = 0;
		int next = 1;

		while (curr < intervals.size()-1){
			if(intervals.get(next).start <= intervals.get(curr).end){
				if(intervals.get(next).end > intervals.get(curr).end) {
					intervals.get(curr).end = intervals.get(next).end;
				}
				intervals.remove(next);
			} else {
				next ++;
				curr ++;
			}
		}

		return intervals;
	}

	public static void sort(List<Interval> intervals){
		Collections.sort(intervals, (i1,i2)->  Integer.valueOf(i1.start).compareTo(i2.start));
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

