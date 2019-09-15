package com.hemalatha.recursion;

import java.util.Date;

public class StringCompression {

	public static void main(String[] args) {

		Date expirationDate = new Date(Long.parseLong("1555367144051"));
		System.out.println(expirationDate);
		Date cancellation = new Date(Long.parseLong("1552752606947"));
		System.out.println(cancellation);
		Date startTime = new Date(Long.parseLong("1552688767007"));
		System.out.println(startTime);
		String input = "aaaa";
		input = "aaaa";
		CompressedString s = doStringCompress(input);
		//System.out.println(s);

		//input = "abdddddabdddddabdddddabddddd";
		input = "abdabdabdabdc";
		s = doStringCompress(input);
		System.out.println(s);
	}

	public static   CompressedString doStringCompress(String input){
		CompressedString res = new CompressedString(input,1);

		for(int i=1;i<input.length();i++){
			CompressedString left = doStringCompress(input.substring(0,i));
			CompressedString right = doStringCompress(input.substring(i,input.length()));

			if(left.getValue().equals(right.getValue())){
				if(left.length() < res.length()) {
					res = new CompressedString(left.getValue(), left.getRepetitions() + right.getRepetitions());
				}
			} else{
				String curr = left.toString() + right.toString();
				if(curr.length() < res.length()){
					res = new CompressedString(curr,1);
				}
			}
		}
		return res;
	}
}


class CompressedString {

	private String value;
	private int repetitions;

	public CompressedString(String value, int repetitions) {
		this.value = value;
		this.repetitions = repetitions;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int length() {
		if (repetitions == 1)
			 return value.length();
		return value.length() + 3;
	}

	public int getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}

	@Override
	public String toString() {
		if (repetitions == 1)
			return value;
		return "" + repetitions + "[" + value + "]";
	}
}
