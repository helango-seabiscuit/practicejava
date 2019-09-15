package com.hemalatha.leetcode.DynamicProgramming;

public class LongestSubstringSum {

	public static void main(String[] args) {
		LongestSubstringSum sum = new LongestSubstringSum();
		System.out.println(sum.substringSumHalf("142124"));
		System.out.println(sum.substringSumHalf("9430723"));
	}

	public int substringSumHalf(String s){
		if(s == null || s.isEmpty() ){
			return 0;
		}
		int n = s.length();
		int maxLen = 0;
		for(int i=2;i<=n;i+=2){

			for(int j=0;j<=n-i;j++){
				String sub = s.substring(j,j+i);
				if(halfEquals(sub)){
					maxLen = Math.max(maxLen, sub.length());
				}
			}
		}
		return maxLen;
	}

	public boolean halfEquals(String s){
		int l=0;
		int r=0;
		for(int i=0,j=s.length()-1;i<j;i++,j--){
			l += s.charAt(i)-'0';
			r+= s.charAt(j)-'0';
		}
		return  l==r;
	}
}
