package com.hemalatha.leetcode;

public class MaskPII {

	public static void main(String[] args) {
		MaskPII maskPII = new MaskPII();
//		System.out.println(maskPII.maskPII("LeetCode@LeetCode.com"));
//		System.out.println(maskPII.maskPII("AB@qq.com"));
//		System.out.println(maskPII.maskPII("1(234)567-890"));
		System.out.println(maskPII.maskPII("+111 111 111 1111"));
		System.out.println(" ".isEmpty());
	}

	public String maskPII(String S) {
		if(!Character.isLetter(S.charAt(0))){
			return maskPhone(S);
		}
		return maskEmail(S);
	}

	private String maskEmail(String s){
		char[] arr = s.toCharArray();
		int i=0;
		for(;arr[i]!='@' && i<arr.length;i++);

		if(i>=arr.length){
			return null;
		}
		char st[] = new char[7+arr.length-i];
		st[0]= Character.toLowerCase(arr[0]);
		int k=5;
		while(k>0){
			st[k]='*';
			k--;
		}
		st[6]=Character.toLowerCase(arr[i-1]);
		k=7;
		for(;i<arr.length;){
			st[k]=Character.toLowerCase(arr[i]);
			i++;
			k++;
		}
		return new String(st);

	}

	private String maskPhone(String s){
		StringBuilder sb = new StringBuilder();
		char[] arr = s.toCharArray();
		int k=4;
		int numLength = 0;
		boolean isSign=false;
		for(int i=arr.length-1;i>=0;i--){
			if(Character.isDigit(arr[i])) {
				if (k > 0) {
					sb.insert(0, arr[i]);
					k--;
				}
				numLength++;
			}
		}


		String maskDigit = "***-***-";
		sb.insert(0,maskDigit);
		if(numLength > 10){
			int diff = numLength - 10;
			sb.insert(0,"-");
			while(diff >0){
				sb.insert(0,"*");
				diff--;
			}
			sb.insert(0,"+");
		}
		return sb.toString();
	}
}
