package com.hemalatha.leetcode;

public class LongPressed {

	/**
	 * Input: name = "alex", typed = "aaleex"
	 Output: true
	 Explanation: 'a' and 'e' in 'alex' were long pressed.

	 Example 2:

	 Input: name = "saeed", typed = "ssaaedd"
	 Output: false
	 Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.

	 Example 3:

	 Input: name = "leelee", typed = "lleeelee"
	 Output: true

	 Example 4:

	 Input: name = "laiden", typed = "laiden"
	 Output: true
	 Explanation: It's not necessary to long press any character.


	 */

	public static void main(String[] args) {
      LongPressed longPressed = new LongPressed();
		System.out.println(longPressed.isLongPressedName("alex",  "aaleex"));//true
		System.out.println(longPressed.isLongPressedName("saeed", "ssaaedd"));//false
		System.out.println(longPressed.isLongPressedName("leelee",  "lleeelee"));//true
		System.out.println(longPressed.isLongPressedName("laiden",  "laiden")); //true
	}

	public boolean isLongPressedName(String name, String typed) {
		char[] nameChar = name.toCharArray();
		char[] typedChar = typed.toCharArray();
		int k = 0, l = 0;

		for (int i = 0, j = 0; i < nameChar.length && j < nameChar.length; ) {
			while (j  < nameChar.length && nameChar[i] == nameChar[j] ) {
				j++;
			}
			int len = j - i;
			while (l < typedChar.length && nameChar[i] == typedChar[k] && typedChar[k] == typedChar[l] )
				l++;

			int len2 = l - k;
			if(len2 >=len) {
				i = j;
				k = l;
				continue;
			}

			return false;

		}

		return true;
	}
}
