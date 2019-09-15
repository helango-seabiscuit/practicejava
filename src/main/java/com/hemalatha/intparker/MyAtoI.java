package com.hemalatha.intparker;


public class MyAtoI {

	public static void main(String[] args) {
		MyAtoI myAtoI = new MyAtoI();
		System.out.println(myAtoI.myAtoi("  -42"));
		System.out.println(myAtoI.myAtoi("-91283472332"));
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		//int i = Integer.valueOf("-91283472332");
		//System.out.println(i);
	}
		public int myAtoi(String str) {
			if(str.isEmpty() || Character.isAlphabetic(str.charAt(0))){
				return 0;
			}
            String s = str.trim();
			return myAtoiMeth(s.toCharArray());

		}

		private int myAtoiMeth(char[] str){
			int pos = 10;
			boolean isNegative = str[0] == '-';
			int i = isNegative ? 1: 0;
			int res = 0;
			int temp = 0;
			for(;i< str.length; i++){
				if(Character.isDigit(str[i])) {

					if(Integer.MAX_VALUE/10 < res || Integer.MAX_VALUE/10 == res && Integer.MAX_VALUE %10 < res)
						return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
					res = res * pos + str[i] - '0';

				} else if(Character.isAlphabetic(str[i])) {
					break;
				}
			}

			if(isNegative){
				res = res *-1;
			}
			return res;
		}

}
