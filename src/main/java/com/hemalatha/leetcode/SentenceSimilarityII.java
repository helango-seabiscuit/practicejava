package com.hemalatha.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/sentence-similarity-ii/description/
public class SentenceSimilarityII {


	public static void main(String[] args) {
		SentenceSimilarityII similarityII = new SentenceSimilarityII();
		String []words1 = new String[] {"great", "acting", "skills"};
		String words2[] = new String[]{"fine", "drama", "talent"};
		String pairs[][] = new String [][]{{"great", "good"},
										   {"fine", "good"},
										   {"acting","drama"},
										   {"skills","talent"}};

		words1 = new String[] {"great"};
		words2 = new String[]{"great"};
		pairs = new String [0][0];
		System.out.println(similarityII.areSentencesSimilarTwo(words1,words2,pairs));
	}
	HashMap<String,Integer> temp = new HashMap<>();
	int [] connComp;
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
		int len1 = words1.length;
		int len2 = words2.length;
		int pairlen = pairs.length;

		if(len1 == 0 && len2 == 0){
			return true;
		}

		if(len1 != len2 || len1 ==0 || len2 ==0){
			return false;
		}

		String arr [] = new String[len1+len2+pairlen];
		int i=0;
		for(String s: words1){
			if(!temp.containsKey(s)){
				arr[i++] = s;
				temp.put(s,i-1);
			}
		}

		for(String s: words2){
			if(!temp.containsKey(s)){
				arr[i++] = s;
				temp.put(s,i-1);
			}
		}

		for(int j=0;j<pairs.length;j++){
			String l = pairs[j][0];
			String r = pairs[j][1];
			if(!temp.containsKey(l)){
				arr[i++] = l;
				temp.put(l,i-1);
			}

			if(!temp.containsKey(r)){
				arr[i++] = r;
				temp.put(r,i-1);
			}
		}

		connComp = new int[temp.size()];
		for(int k=0; k<temp.size();k++){
			connComp[k] = k;
		}
		for(int j=0;j<pairs.length;j++){
			String l = pairs[j][0];
			String r = pairs[j][1];
			union(temp.get(l),temp.get(r));
		}


		for(int p = 0;p<len1;p++){
			int w1 = find(temp.get(words1[p]));
			int w2 = find(temp.get(words2[p]));
			if(w1 != w2){
				return false;
			}
		}
		return true;
	}


	public void union(Integer l, Integer r){
		connComp[find(l)] = connComp[find(r)];

	}

	public int find(int k){
		if(connComp[k] != k){
			return find(connComp[k]);
		}
		return connComp[k];
	}
}
