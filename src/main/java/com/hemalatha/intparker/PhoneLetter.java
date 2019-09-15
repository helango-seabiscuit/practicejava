package com.hemalatha.intparker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneLetter {

	private static Map<Integer,String> mapper;

	static {
		mapper = new HashMap<>();
		mapper.put(2,"abc");
		mapper.put(3,"def");
		mapper.put(4,"ghi");
		mapper.put(5,"jkl");
		mapper.put(6,"mno");
		mapper.put(7,"pqrs");
		mapper.put(8,"tuv");
		mapper.put(9,"wxyz");
	}

	public static void main(String[] args) {
       String number = "23";
       letterToString(number,0,"");
       System.out.println(numWays);
       System.out.println(answer);
       System.out.println(-5%2);
	}

	private static  int numWays = 0;
	private static List<String> answer = new ArrayList<>();

	private static void letterToString(String num, int index, String res){
		if(num.length() == res.length()){
			answer.add(res);
			numWays++;
			return;
		}

		char ct = num.charAt(index);
		String map = mapper.get(ct - '0');
		for(Character c: map.toCharArray()){
			letterToString(num,index+1,res+c);
		}
	}
}
