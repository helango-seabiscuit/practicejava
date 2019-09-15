package com.hemalatha.leetcode;



import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class OrderWords {

	public static void main(String[] args) {
        OrderWords words = new OrderWords();
		System.out.println(words.isAlienSorted(new String[]{"hello","leetcode"},  "hlabcdefgijkmnopqrstuvwxyz"));
		System.out.println(words.isAlienSorted(new String[]{"word","world","row"},  "worldabcefghijkmnpqstuvxyz"));
		System.out.println(words.isAlienSorted(new String[]{"apple","app"},  "abcdefghijklmnopqrstuvwxyz"));
		System.out.println(new LanguageComparator("worldabcefghijkmnpqstuvxyz").compare("word","world"));
//		String[] s = new String[]{"word","world","row"};
//		Arrays.sort(s,new LanguageComparator("worldabcefghijkmnpqstuvxyz"));
//		Arrays.toString(s);
	}

	public boolean isAlienSorted(String[] words, String order) {

		String[] original = new String[words.length];
		int i=0;
		for(String a:words){
			original[i++]= a;
		}
		Arrays.sort(original,new LanguageComparator(order));

		int k=0;
		for(String s:original){
			if(!s.equalsIgnoreCase(words[k++])){
				return false;
			}
		}

		return true;

	}

	static class LanguageComparator implements Comparator<String>{

		private Map<Character,Integer> orderMap;
		public LanguageComparator(String order){
			orderMap = new HashMap<>();
			for(int i=0;i<order.length();i++){
				orderMap.put(order.charAt(i),i);
			}
		}

		@Override
		public int compare(String o1, String o2) {
			int s1 = o1.length();
			int s2 = o2.length();
			int i=0; int j=0;
			while (i <s1 && j<s2){
				if(orderMap.get(o1.charAt(i))==(orderMap.get(o2.charAt(j)))){
					i++;
					j++;
					 continue;

				}
				return orderMap.get(o1.charAt(i)).compareTo(orderMap.get(o2.charAt(j)));

			}
			if(i==s1 && j==s2){
				return 0;
			}

			return i==s1?-1:1;

		}
	}
}
