package com.hemalatha.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class FrequencyCount {

	public static void main(String[] args) {
		FrequencyCount frequencyCount = new FrequencyCount();
		System.out.println(frequencyCount.frequencySort("tree"));//eert
		System.out.println(frequencyCount.frequencySort("cccaaa"));//aaaccc
		System.out.println(frequencyCount.frequencySort("Aabb"));//bbAa
	}

	public String frequencySort(String s) {
		PriorityQueue<CharacterTracker> counts = new PriorityQueue<>((c1, c2)->{
				return c2.getFrequency().compareTo(c1.getFrequency());
		});

		Map<Character,CharacterTracker> trackerMap = new HashMap<>();
		for(Character c: s.toCharArray()){
			CharacterTracker tracker = null;
			if(trackerMap.get(c) != null){
				tracker = trackerMap.get(c);
				counts.remove(tracker);
				tracker.setFrequency(tracker.getFrequency()+1);
				counts.add(tracker);
			}else{
				tracker = new CharacterTracker(c);
				trackerMap.put(c,tracker);
				counts.add(tracker);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!counts.isEmpty()){
			CharacterTracker t = counts.poll();
			int i = t.getFrequency();
			while (i>0){
				sb.append(t.getCharacter());
				i--;
			}
		}

		return sb.toString();
	}
}

class CharacterTracker {

	private Character character;
	private Integer frequency;

	public CharacterTracker(Character character) {
		this.character = character;
		this.frequency = 1;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public Character getCharacter() {
		return character;
	}

	@Override
	public int hashCode() {
		return this.character.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}else{
			if(!(obj instanceof CharacterTracker)){
				return false;
			}
			CharacterTracker o = (CharacterTracker)obj;
			return o.character == this.character;
		}
	}


}
