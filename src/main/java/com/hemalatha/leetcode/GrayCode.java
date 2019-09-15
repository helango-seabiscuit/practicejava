package com.hemalatha.leetcode;

public class GrayCode {

	public static void main(String[] args) {
		GrayCode code = new GrayCode();
		System.out.println(code.isGrayCode(0,1));
		System.out.println(code.isGrayCode(1,2));
		System.out.println(code.isGrayCode(0,2));
		System.out.println(code.isGrayCode(0,3));
	}


	public boolean isGrayCode(int n,int t){
//		int c=0;
//		while (n!=0 || t!=0){
//			if((n & 1) != (t &1)){
//				c++;
//			}
//			n = n>>1;
//			t = t>>1;
//		}
//
//		return c==1;

		int x = n^t;
		return (x &(x-1))==0;
	}




}



//  // This is the interface that allows for creating nested lists.
//  // You should not implement it, or speculate about its implementation
//  public interface NestedInteger {
//      // Constructor initializes an empty nested list.
//      public NestedInteger();
//
//      // Constructor initializes a single integer.
//      public NestedInteger(int value);
//
//      // @return true if this NestedInteger holds a single integer, rather than a nested list.
//      public boolean isInteger();
//
//      // @return the single integer that this NestedInteger holds, if it holds a single integer
//      // Return null if this NestedInteger holds a nested list
//      public Integer getInteger();
//
//      // Set this NestedInteger to hold a single integer.
//      public void setInteger(int value);
//
//      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//      public void add(NestedInteger ni);
//
//      // @return the nested list that this NestedInteger holds, if it holds a nested list
//      // Return null if this NestedInteger holds a single integer
//      public List<NestedInteger> getList();
//  }

