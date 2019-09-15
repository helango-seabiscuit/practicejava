package com.hemalatha.recursion;

public class EditDistance {

	public static void main(String[] args) {
		System.out.println(editDistance("abc","cab"));
	}

   public static  int editDistance(String s1, String s2){

   	if(s1 == null || s1.isEmpty()){
   		return s2.length();
	}

	if(s2==null || s2.isEmpty()){
   		return s1.length();
	}

	if(s1.charAt(0)==s2.charAt(0)){
   		return editDistance(s1.substring(1),s2.substring(1));
	}

	int d = editDistance(s1.substring(1),s2);
	int u = editDistance(s1.substring(1),s2.substring(1));
	int i = editDistance(s1,s2.substring(1));

	return Math.min(Math.min(d,u),i)+1;
   }
}
