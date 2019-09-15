package com.hemalatha.leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniqueFirstCharacter {

	public static void main(String[] args) {
		UniqueFirstCharacter character = new UniqueFirstCharacter();
		System.out.println(character.firstUniqChar("leetcode")); //0
		System.out.println(character.firstUniqChar("loveleetcode"));//2
	}

	public int firstUniqChar(String s) {
		Map<Character,Boolean> cache = new HashMap<>();

		for(Character c:s.toCharArray()){
			if(cache.containsKey(c)){
				cache.put(c,true);
			}else{
				cache.put(c,false);
			}
		}

		int i=0;
		for(Character c:s.toCharArray()){
			if(cache.get(c)==false){
				return i;
			}
			i++;
		}

		return -1;
	}



}
