package com.hemalatha.jcg;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {

	private static Map<String,String> mapString;

	static {
		mapString = new HashMap<>();
		mapString.put("0","0");
		mapString.put("1","1");
		mapString.put("2","abc");
		mapString.put("3","def");
		mapString.put("4","ghi");
		mapString.put("5","jkl");
		mapString.put("6","mno");
		mapString.put("7","pqr");
		mapString.put("8","stu");
		mapString.put("9","vwx");
	}

	public static void main(String[] args) {
		//String phone = "9259987514";
		String phone = "23";
		mapToString(phone,new StringBuilder(),0);
	}

	public static void mapToString(String phone, StringBuilder sb, int index){

		if(index ==  phone.length()){
			System.out.println(sb.toString());
			return;
		}

		char s = phone.charAt(index);
		String mapStr = mapString.get(Character.toString(s));
		int mapLen = mapStr.length();
		for(int i=0;i< mapLen;i++){
			sb.append(mapStr.charAt(i));
			mapToString(phone,sb,index+1);
			sb.deleteCharAt(sb.length()-1);
		}

	}

}
