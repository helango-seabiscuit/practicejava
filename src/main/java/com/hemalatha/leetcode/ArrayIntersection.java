package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayIntersection {

	public static void main(String[] args) {
		ArrayIntersection intersection = new ArrayIntersection();
		System.out.println(Arrays.toString(intersection.intersect(new int[]{1,2,2,1}, new int[]{2,2})));
	}

		public int[] intersect(int[] nums1, int[] nums2) {

			Arrays.sort(nums1);
			Arrays.sort(nums2);
			int l1 = nums1.length;
			int l2 = nums2.length;
			List<Integer> list = new ArrayList<>();
				for(int i=0,j=0;i<l1 && j<l2;){
					if(nums1[i] == nums2[j]) {
						list.add(nums1[i]);
						i++;j++;
					}else if (nums1[i]<nums2[j]){
						i++;
					}else {
						j++;
					}
				}

			int res[] = new int[list.size()];
			int i =0;
			for(int a:list){
				res[i++]=a;
			}
			return res;
		}

		private int binarySearch(int []nums,int a) {
			int left = 0;
			int right = nums.length - 1;

			while (left <= right) {
				int mid = left + (right - left) / 2;

				if (nums[mid] == a) {
					return mid;
				} else if (nums[mid] < a) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			return -1;
		}
}
