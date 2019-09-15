package com.hemalatha.interview.patternsearch;

public class LongestCommonSubSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int length = longestCommonSubsequence("hemalatha","hema");
		System.out.println("Length of longest common subsequence :"+length);

	}
	
	 public static int longestCommonSubsequence(String a, String b) {
	        if (a == null) {
	            throw new IllegalArgumentException("a must be non-null");
	        }
	        if (b == null) {
	            throw new IllegalArgumentException("b must be non-null");
	        }

	        byte x[] = a.getBytes();
	        byte y[] = b.getBytes();
	        int l[][] = new int[x.length + 1][y.length + 1];

	        for (int i = x.length - 1; i >= 0; i--) {
	            for (int j = y.length - 1; j >= 0; j--) {
	                l[i][j] = (x[i] == y[j])
	                        ? l[i + 1][j + 1] + 1
	                        : Math.max(l[i + 1][j], l[i][j + 1]);
	            }
	        }

	        return l[0][0];
	    }

}
