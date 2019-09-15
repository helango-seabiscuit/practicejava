package com.hemalatha.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class NumberOfAtoms {

	private Stack<Integer> globalCounter = new Stack<>();
	private  Map<String,Integer> atoms = new TreeMap<>();
	private String prev = "";

	public static void main(String[] args) {
		NumberOfAtoms atomCalculator = new NumberOfAtoms();
//		atomCalculator.atomCounter("H2O",0);
//		for(Character c:atomCalculator.atoms.keySet()){
//			System.out.println(c +"->"+atomCalculator.atoms.get(c));
//		}


		atomCalculator = new NumberOfAtoms();
		//atomCalculator.atomCounter("H2O2(O5)2",0);
		//atomCalculator.atomCounter("K4(ON(SO3)2)2",0);
		//atomCalculator.atomCounter("Mg(OH)2",0);
		atomCalculator.atomCounter("Be32",0);
//		for(String c:atomCalculator.atoms.keySet()){
//			System.out.println(c +"->"+atomCalculator.atoms.get(c));
//		}
		StringBuilder sb = new StringBuilder();
		for(String c:atomCalculator.atoms.keySet()){
			sb.append(c +(atomCalculator.atoms.get(c) > 1? atomCalculator.atoms.get(c):""));
		}
		System.out.println(sb.toString());
	}

	public int atomCounter(String s, int index){
		if(index == s.length()){
			return 1;
		}
		int res = atomCounter(s,index+1);
		char curr = s.charAt(index);
		if(curr == ')'){
			globalCounter.push(res);
			return 1;
		} else if(curr =='(') {
           globalCounter.pop();
		}
		else if (Character.isDigit(curr)){
			return curr-'0';
		} else if(Character.isLetter(curr)){
			if(Character.isLowerCase(curr)){
				prev = curr+prev;
			}else {
				prev = curr+prev;
				if (!atoms.containsKey(prev)) {
					for (Integer i : globalCounter.stream().collect(Collectors.toList())) {
						res = res * i;
					}
					atoms.put(prev, res);
				} else {
					for (Integer i : globalCounter.stream().collect(Collectors.toList())) {
						res = res * i;
					}
					atoms.put(prev, atoms.get(prev) + (res));
				}
				prev ="";
			}
		}
        return 1;
	}
}
