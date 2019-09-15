package com.hemalatha.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock {

	public static void main(String[] args) {
		String s="0000";
//		for (int i=0;i<4;i++){
//			char c = s.charAt(i);
//			String s1 = s.substring(0,i)+ String.valueOf(c=='0'?9:((c-'0')-1))+s.substring(i+1);
//			String s2 = s.substring(0,i)+ String.valueOf(c=='9'?0:((c-'0')+1))+s.substring(i+1);
//			System.out.println(s1);
//			System.out.println(s2);
//		}

		OpenLock lock = new OpenLock();
		System.out.println(lock.openLock(new String[]{"0201","0101","0102","1212","2002"},"0202"));//6
		System.out.println(lock.openLock(new String[]{"8888"},"0009"));//1
		System.out.println(lock.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},"8888"));//-1
		System.out.println(lock.openLock(new String[]{"0000"},"8888"));//-1
	}

	public int openLock(String[] deadends, String target) {

		Set<String> deads = new HashSet<>();
		Set<String> visited = new HashSet<>();
		for(String s:deadends){
			deads.add(s);
		}

		String initial = "0000";
		Queue<String> queue = new LinkedList<>();
		queue.add(initial);
		int level =0;
		while (!queue.isEmpty()){
			int size = queue.size();

			while (size>0){
				String s = queue.poll();
				if(deads.contains(s)){
					size--;
					continue;
				}
				if(s.equals(target)){
					return level;
				}
				for (int i=0;i<4;i++){
					char c = s.charAt(i);
					String s1 = s.substring(0,i)+ String.valueOf(c=='0'?9:((c-'0')-1))+s.substring(i+1);
					String s2 = s.substring(0,i)+ String.valueOf(c=='9'?0:((c-'0')+1))+s.substring(i+1);

					if(!deads.contains(s1) && !visited.contains(s1)){
						queue.add(s1);
						visited.add(s1);
					}

					if(!deads.contains(s2) && !visited.contains(s2)){
						queue.add(s2);
						visited.add(s2);
					}
				}
				size--;
			}
			level++;
		}
		return -1;
	}
}
