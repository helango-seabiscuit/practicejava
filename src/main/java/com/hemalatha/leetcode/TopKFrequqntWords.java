package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequqntWords {

	public static void main(String[] args) {
		TopKFrequqntWords words = new TopKFrequqntWords();
		//System.out.println(words.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2));//["i", "love"]
		System.out.println(words.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},4));
		System.out.println(words.topKFrequentSimple(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},4));
		//["the", "is", "sunny", "day"]
	}

	public List<String> topKFrequentSimple(String[] words, int k) {
		Map<String,Integer> map = new HashMap<>();
		for(String s:words){
			map.put(s,map.getOrDefault(s,0)+1);
		}

		ArrayList<String> res = new ArrayList<>(map.keySet());
		Collections.sort(res,(w1,w2)->{
			if(map.get(w1).compareTo(map.get(w2))==0){
				return w1.compareTo(w2);
			}
			return map.get(w2).compareTo(map.get(w1));
		});
		return res.subList(0,k);

	}

	public List<String> topKFrequent(String[] words, int k) {

		PriorityQueue<Word> queue = new PriorityQueue<Word>((w1,w2)->{
			if(w2.frequency.compareTo(w1.frequency)==0){
				return w1.rep.compareTo(w2.rep);
			}
			return w2.frequency.compareTo(w1.frequency);
		});

		Map<String,Word> map = new HashMap<>();
		for (String s:words){
			Word d = null;
			if(map.get(s)!=null){
				d = map.get(s);
				queue.remove(d);
				d.frequency = d.frequency+1;
			}else{
				d = new Word(s);
				map.put(s,d);
			}
			queue.add(d);
		}

		List<String> res = new ArrayList<>();
		while (k>0){
			Word t = queue.poll();
			res.add(t.rep);
			k--;
		}
       return res;
	}
}



class Word {
	String rep;
	Integer frequency;

	public Word(String rep) {
		this.rep = rep;
		this.frequency = 1;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public int hashCode() {
		return this.rep.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.rep.equalsIgnoreCase(((Word)obj).rep);
	}
}
