package com.hemalatha.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class NextGreatestLetter {

	public static void main(String[] args) {
		NextGreatestLetter letter = new NextGreatestLetter();
		System.out.println(letter.nextGreatestLetter(new char[]{'e','e','e','e','e','e','n','n','n','n'},'e'));
	}

	public char nextGreatestLetter(char[] a, char x){
		int n = a.length;

		//hi starts at 'n' rather than the usual 'n - 1'.
		//It is because the terminal condition is 'lo < hi' and if hi starts from 'n - 1',
		//we can never consider value at index 'n - 1'
		int lo = 0, hi = n;

		//Terminal condition is 'lo < hi', to avoid infinite loop when target is smaller than the first element
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (a[mid] > x)     hi = mid;
			else    lo = mid + 1;                 //a[mid] <= x
		}

		//Because lo can end up pointing to index 'n', in which case we return the first element
		return a[lo % n];
	}

	public char nextGreatestLetter2(char[] letters, char target) {
		letters = removeDuplicates(letters);
		int left =0;
		int right = letters.length-1;

		while(left+1<right){

			int mid = left + (right-left)/2;
			if(letters[mid]<target){
				left = mid;
			}else if(letters[mid]>target){
				right = mid;
			}else{
				return letters[mid+1];
			}
		}

		if(target < letters[left]){
			return letters[left];
		}

		if(target >= letters[right]){
			return letters[0];
		}

		if(target >= letters[left]){
			return letters[right];
		}

		return '0';

	}

	private char[] removeDuplicates(char[] letters) {

		Set<Character> c = new TreeSet<>();
		for(Character l:letters){
			c.add(l);
		}
		char res [] = new char[c.size()];
		int i=0;
		for(Character l:c){
			res[i++] = l;
		}
		return res;

	}
}
