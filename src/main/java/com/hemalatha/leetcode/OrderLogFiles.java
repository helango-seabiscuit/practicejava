package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderLogFiles {

	public static void main(String[] args) {


		String input[] = new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
		System.out.println(Arrays.deepToString(reorderLogFiles(input)));
	}

	public static String[] reorderLogFiles(String[] logs) {
		List<String> list = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		for(String s:logs){
			if(Character.isDigit(s.split(" ")[1].charAt(0))){
				list.add(s);
			}else {
				list2.add(s);
			}

		}
		Collections.sort(list2, new LogComparator());
		list2.addAll(list);
		return list2.toArray(logs);
	}
}

class LogComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		String s1[] = o1.split(" ");
		String s2[] = o2.split(" ");
		int n = Math.min(s1.length, s2.length);
		int i = 1;
		while(i < n){
			if( s1[i].compareTo(s2[i]) != 0 ) {
				return s1[i].compareTo(s2[i]);
			}
			i++;
		}
		return s1[0].compareTo(s2[0]);
	}
}
