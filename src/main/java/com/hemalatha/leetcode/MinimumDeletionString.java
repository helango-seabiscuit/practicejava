package com.hemalatha.leetcode;

import java.util.Arrays;

public class MinimumDeletionString {

	public static void main(String[] args) {
		MinimumDeletionString deletionString = new MinimumDeletionString();
//		System.out.println(deletionString.minDeletionSize(new String []{"cba","daf","ghi"}));
//		System.out.println(deletionString.minDeletionSize(new String []{"a","b"}));
//		System.out.println(deletionString.minDeletionSize(new String []{"zyx","wvu","tsr"}));
		Arrays.stream(deletionString.diStringMatch("IDID")).forEach(System.out::print);
		System.out.println();
		Arrays.stream(deletionString.diStringMatch("III")).forEach(System.out::print);
		System.out.println();
		Arrays.stream(deletionString.diStringMatch("DDI")).forEach(System.out::print);
	}

	public int minDeletionSize(String[] A) {
      int len = A[0].length();
      int totlen = A.length;
      int res = 0;
      for(int i=0;i<len;i++){
      	char prev = A[0].charAt(i);
      	for(int j=1;j<totlen;j++){
      		char curr = A[j].charAt(i);
      		if(prev > curr){
      			res++;
      			break;
			}
			prev = curr;
		}
	  }
	  return res;
	}

	public int[] diStringMatch(String S) {
       int [] res = new int[S.length()+1];
       int low = 0;
       int high = S.length();
		int i=0;
       for(;i<S.length();i++){
       	char c = S.charAt(i);
       	if(c == 'I'){
       		res[i]= low;
       		low++;
		}else{
       		res[i] = high;
       		high--;
		}
	   }

	   if(high >= low){
       	res[i] = high;
	   }

	   return res;

	}
}
