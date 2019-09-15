package com.hemalatha.leetcode;

import java.util.Arrays;

public class SumSegmentTree {

	int len;
	int [] numArr;
	public static void main(String[] args) {
		SumSegmentTree segmentTree = new SumSegmentTree();
		int[] nums = new int[]{2,4,5,7,8,9};
		Arrays.stream(segmentTree.buildTree(nums)).forEach(i->System.out.print(" "+i));
		segmentTree.update(8,3);
		System.out.println();
		Arrays.stream(segmentTree.numArr).forEach(i->System.out.print(" "+i));
	}

	public int[] buildTree(int[] nums){
		len = nums.length;
		numArr = new int[2*len];

		for(int i=len,j=0;i<2*len;i++,j++){
			numArr[i] = nums[j];
		}

		for(int i=len-1;i>=0;i--){
			numArr[i] = numArr[2*i]+numArr[2*i+1];
		}

		return numArr;
	}

	public void update(int value,int idx){
		idx += len;
		numArr[idx] = value;

		while(idx > 0){
			int left = idx;
			int right = idx;

			if(idx % 2 == 0){
				right = idx +1;
			}else{
				left = idx -1;
			}
			numArr[idx/2]= numArr[left]+numArr[right];
			idx = idx/2;
		}

	}

	public int sumQueryRange(int l, int r){
		l+=len;
		r+=len;
		int sum = 0;
		while (l<=r){
			if(l%2 ==1){
				sum += numArr[l];
				l++;
			}

			if(r%2 == 0){
				sum += numArr[r];
				r--;
			}

			l /= 2;
			r /= 2;
		}
		return sum;
	}
}
