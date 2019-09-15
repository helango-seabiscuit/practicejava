package com.hemalatha.leetcode;

public class DuplicateNumber {

	public static void main(String[] args) {
		DuplicateNumber number = new DuplicateNumber();
		System.out.println(number.duplicateNumber(new int[]{3,1,3,4,2}));
		System.out.println(number.duplicateNumber(new int[]{1,3,4,2,2}));
	}

	public  int duplicateNumber(int[] n){
		int hare =n[0];
		int tortoise = n[0];
       //find intersection point of cycle
		do {
			tortoise = n[tortoise];
			hare = n[n[hare]];
		}while (hare != tortoise);


		System.out.println("Hare: "+hare );
		System.out.println("tortoise: "+tortoise );

		//find entrance to the cycle
		int ptr1 = n[0];
		int ptr2 = tortoise;

		while (ptr1 != ptr2){
			ptr1 = n[ptr1];
			ptr2 = n[ptr2];
		}
		return ptr1;
	}
}
