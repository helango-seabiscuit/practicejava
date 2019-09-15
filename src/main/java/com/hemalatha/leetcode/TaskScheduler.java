package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

	public static void main(String[] args) {
		TaskScheduler scheduler = new TaskScheduler();
		//System.out.println(scheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
		System.out.println(scheduler.leastInterval(new char[]{'A','A'}, 2));
		System.out.println(scheduler.leastInterval(new char[]{'A','A','B','C','C','D','A','B','D','E'}, 6));
		System.out.println(scheduler.leastInterval(new char[]{'A','A','C','C','C','B','B','A','A','C','C'}, 4));
		//System.out.println(scheduler.test(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
	}

	public int leastInterval(char[] tasks, int n) {
		int[] tempTask = new int[26];
		for (Character c : tasks) {
			tempTask[c - 'A'] += 1;
		}
		//Arrays.sort(tempTask);
		Queue<Integer> queue = new PriorityQueue<>(26, Comparator.reverseOrder());
		for (int i = 25; i >= 0; i--) {
			if (tempTask[i] > 0) {
				queue.add(tempTask[i]);
			}
		}

		int resTime = 0;

		while (!queue.isEmpty()) {
			List<Integer> temp = new LinkedList<>();
			int i = 0;
			while (i <= n) {

				if (!queue.isEmpty()) {
					if (queue.peek() > 1) {
						temp.add(queue.poll() - 1);
					} else {
						queue.poll();
					}
				}

				resTime++;
				if (queue.isEmpty() && temp.isEmpty()) {
					break;
				}
				i++;

			}
			for (Integer elem : temp) {
				queue.add(elem);
			}
		}

		return resTime;

	}

	public int test(char[] tasks, int n) {
		int[] map = new int[26];
		for (char c: tasks)
			map[c - 'A']++;
		Arrays.sort(map);
		int time = 0;
		while (map[25] > 0) {
			int i = 0;
			while (i <= n) {
				if (map[25] == 0)
					break;
				if (i < 26 && map[25 - i] > 0)
					map[25 - i]--;
				time++;
				i++;
			}
			Arrays.sort(map);
		}
		return time;
	}



}
