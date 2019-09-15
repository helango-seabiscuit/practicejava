package com.hemalatha.recursion;

import java.util.LinkedList;
import java.util.List;

public class StairSteps {

	public static void main(String[] args) {
		System.out.println(stairSteps(2,0));
		System.out.println(stairSteps(3,0));
		System.out.println(stairSteps(4,0));
	}

	public static List<List<Integer>> stairSteps(int n,int currStep){

		if(currStep == n){
			LinkedList<List<Integer>> res = new LinkedList<>();
			LinkedList<Integer> r = new LinkedList<>();
			r.add(currStep);
			res.add(r);
			return res;
		}

		if(currStep > n){
			return new LinkedList<>();
		}

		LinkedList<List<Integer>> res = new LinkedList<>();
		res.addAll(stairSteps(n,currStep+1));
		res.addAll(stairSteps(n,currStep+2));
		res.addAll(stairSteps(n,currStep+3));

		for(List l:res){
			l.add(0,currStep);
		}
		return res;
	}
}
