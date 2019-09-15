package com.hemalatha.leetcode.DynamicProgramming;

public class CanJump {

	public static void main(String[] args) {
		CanJump jump = new CanJump();
		System.out.println(jump.canJump(new int[]{2,3,1,1,4}));//true
		System.out.println(jump.canJump(new int[]{3,2,1,0,4}));//false
		System.out.println(jump.canJump(new int[]{2,0,0}));//true
	}

	public boolean canJump(int[] nums) {
		return canJump(nums,0);
	}

	public boolean canJump(int[] nums,int i){
		if(i==nums.length-1){
			return true;
		}

		for(int j=1;j<=nums[i];j++){
			if(canJump(nums,i+j)){
				return true;
			}
		}
		return false;
	}
}
