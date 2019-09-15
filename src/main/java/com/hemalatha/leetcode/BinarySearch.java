package com.hemalatha.leetcode;

import java.util.HashSet;
import java.util.Set;

public class BinarySearch {


  //template 1
  int binarySearchTemplate1(int[] nums, int target){
	  if(nums == null || nums.length == 0)
		  return -1;

	  int left = 0, right = nums.length - 1;
	  while(left <= right){
		  // Prevent (left + right) overflow
		  int mid = left + (right - left) / 2;
		  if(nums[mid] == target){ return mid; }
		  else if(nums[mid] < target) { left = mid + 1; }
		  else { right = mid - 1; }
	  }

	  // End Condition: left > right
	  return -1;
  }
  //template 2
  int binarySearchTemplate2(int[] nums, int target){
	  if(nums == null || nums.length == 0)
		  return -1;

	  int left = 0, right = nums.length;
	  while(left < right){
		  // Prevent (left + right) overflow
		  int mid = left + (right - left) / 2;
		  if(nums[mid] == target){ return mid; }
		  else if(nums[mid] < target) { left = mid + 1; }
		  else { right = mid; }
	  }

	  // Post-processing:
	  // End Condition: left == right
	  if(left != nums.length && nums[left] == target) return left;
	  return -1;
  }

  //template 3
  int binarySearchTemplate3(int[] nums, int target) {
	  if (nums == null || nums.length == 0)
		  return -1;

	  int left = 0, right = nums.length - 1;
	  while (left + 1 < right){
		  // Prevent (left + right) overflow
		  int mid = left + (right - left) / 2;
		  if (nums[mid] == target) {
			  return mid;
		  } else if (nums[mid] < target) {
			  left = mid;
		  } else {
			  right = mid;
		  }
	  }


	  // Post-processing:
	  // End Condition: left + 1 == right
	  if(nums[left] == target) return left;
	  if(nums[right] == target) return right;
	  return -1;
  }


	//search in rotated sorted array
	public int search(int[] nums, int target) {

		if(nums == null || nums.length == 0){
			return -1;
		}
		int left = 0;
		int right = nums.length-1;
		int mid = 0;
		for(int i=1;i<nums.length;i++){
			if(nums[i-1]>nums[i]){
				mid = i;
				break;
			}
		}

		do{
			if(nums[mid] == target ){
				return mid;
			}else if(target >nums[mid] && target <= nums[right]){
				left = mid +1;
			}else{
				right = mid -1;
			}
			mid = left + (right-left)/2;
		}while(left <= right);
		return -1;

	}
}
