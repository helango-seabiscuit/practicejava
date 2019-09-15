package com.hemalatha.leetcode;

public class MaximumXORTwoNumbers {

	public static void main(String[] args) {
		MaximumXORTwoNumbers twoNumbers = new MaximumXORTwoNumbers();
		System.out.println(twoNumbers.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
	}

	public int findMaximumXOR(int[] nums) {

		NumTrie root = new NumTrie();
		for(Integer n:nums){
			NumTrie curr = root;
			for(int i=31;i>=0;i--){
				int r = (n >>>i)&1;
				if(curr.getTrie()[r]==null){
					curr.getTrie()[r]=new NumTrie();
				}
				curr = curr.getTrie()[r];
			}
		}

		int max = Integer.MIN_VALUE;
		for(Integer n:nums){
			NumTrie curr = root;
			int curSum =0;
			for(int i=31;i>=0;i--){
				int r = (n>>>i) &1;

				if(curr.getTrie()[r^1]!=null){
				    curSum += (1 << i);
					curr = curr.getTrie()[r^1];
				}else{
					curr = curr.getTrie()[r];
				}

			}
			max = Math.max(curSum,max);
		}

		return max;
	}
}

class NumTrie {

	private NumTrie[] trie;

	public NumTrie() {
		this.trie = new NumTrie[2];
	}

	public NumTrie[] getTrie() {
		return trie;
	}


}
