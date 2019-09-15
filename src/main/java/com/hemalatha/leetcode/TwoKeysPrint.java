package com.hemalatha.leetcode;

public class TwoKeysPrint {

	public static void main(String[] args) {
		TwoKeysPrint print = new TwoKeysPrint();
		System.out.println(print.minSteps(3));
	}

	public int minSteps(int n) {
        return test("A",n,"A",0);
	}

	public  int test(String s,int n, String buffer,int t){
		if(s.length() == n){
			return t;
		}

		return  Math.min(test(s+buffer,n,buffer,t+2),test(s+s,n,buffer,t+1));
	}
}
