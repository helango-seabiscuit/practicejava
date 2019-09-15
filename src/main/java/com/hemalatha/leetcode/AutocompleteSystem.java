package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AutocompleteSystem {

	public static void main(String[] args) {
//		AutocompleteSystem system = new AutocompleteSystem(new String[]{"i love you", "island","ironman", "i love leetcode"},new int[]{5,3,2,2});
//		System.out.println(system.input('i'));
//		System.out.println(system.input(' '));
//		System.out.println(system.input('a'));
//		System.out.println(system.input('#'));
//		System.out.println(system.input('i'));
//		System.out.println(system.input(' '));
//		System.out.println(system.input('a'));
//		System.out.println(system.input('#'));
//		System.out.println(system.input('i'));
//		System.out.println(system.input(' '));
//		System.out.println(system.input('a'));
//		System.out.println(system.input('#'));

		AutocompleteSystem system = new AutocompleteSystem(new String[]{"abc","abbc","a"},new int[]{3,3,3});
		System.out.println(system.input('b'));
		System.out.println(system.input('c'));
		System.out.println(system.input('#'));
		System.out.println(system.input('b'));
		System.out.println(system.input('c'));
		System.out.println(system.input('#'));
		System.out.println(system.input('a'));
		System.out.println(system.input('b'));
		System.out.println(system.input('c'));
		System.out.println(system.input('#'));
		System.out.println(system.input('a'));
		System.out.println(system.input('b'));
		System.out.println(system.input('c'));
		System.out.println(system.input('#'));
	}

	private SearchTrie root;
	private SearchTrie tracker;
	private int currId;
	private StringBuilder sb;
	private SentenceHolder holder;
	private AtomicInteger identifier;
	public AutocompleteSystem(String[] sentences, int[] times) {
        this.root = new SearchTrie(holder);
        this.holder = new SentenceHolder();
        this.identifier = new AtomicInteger(0);
        int i=0;
        for (String s:sentences){
        	int id = identifier.getAndIncrement();
            holder.setSentence(s,id);
            holder.setTimes(id,times[i++]);
            holder.setSentenceHolder(s,id);
            SearchTrie curr = root;
            for(char c:s.toCharArray()){
            	if(curr.getSentence()[c-0]==null){
            		curr.getSentence()[c-0]=new SearchTrie(holder);
				}
				curr = curr.getSentence()[c-0];
            	curr.addTopHots(id);
			}
		}
	}

	public List<String> input(char c) {
		List<String> res = new ArrayList<>();
		if(tracker == null ){
			currId = identifier.getAndIncrement();
			sb = new StringBuilder();
			tracker = root;
		}
		if(c=='#'){

			if(tracker.getTopHots().isEmpty() || holder.getSentenceHolder(sb.toString()) == null){
				if(holder.getSentenceHolder(sb.toString()) == null) {
					holder.setSentence(sb.toString(), currId);
					holder.setTimes(currId, 0);
					holder.setSentenceHolder(sb.toString(), currId);
				}
				addSentence(sb.toString(),currId);
			}else{
				currId = holder.getSentenceHolder(sb.toString());
			}
			holder.setTimes(currId, holder.getTimes(currId)+1);
			tracker = null;
			return res;
		}
		sb.append(c);

		if(tracker.getSentence()[c] == null){
			tracker.getSentence()[c]= new SearchTrie(holder);
		}else {
			List<Integer> it = tracker.getSentence()[c].getTopSortedHots();
			it.forEach(i -> res.add(holder.getSentence(i)));
		}
		tracker = tracker.getSentence()[c];
		return res;
	}

	private void addSentence(String s,Integer id){
		SearchTrie curr = root;
		for(char c:s.toCharArray()){
			if(curr.getSentence()[c-0]==null){
				curr.getSentence()[c-0]=new SearchTrie(holder);
			}
			curr = curr.getSentence()[c-0];
			curr.addTopHots(id);
		}
	}

	public boolean validWordSquare(List<String> words) {


		for(int i=0;i<words.size();i++){
			for(int j=0;j<words.get(i).length();j++){
               if(words.get(j) == null || (words.get(j).length()<i) || (words.get(i).charAt(j) != words.get(j).charAt(i))){
               	return false;
			   }
			}
		}

		return true;

	}


}

class SearchTrie {

	private List<Integer> topHots;
	private SearchTrie[] sentence;
	private SentenceHolder holder;

	public SearchTrie(SentenceHolder holder) {
		this.sentence = new SearchTrie[256];
		this.topHots = new ArrayList<>();
		this.holder = holder;
	}

	public void addTopHots(int id){
		this.getTopHots().add(id);
		this.getTopHots().sort((j,k)-> { if(Integer.valueOf(holder.getTimes(j)).compareTo(holder.getTimes(k))==0){
			return holder.getSentence(j).compareTo(holder.getSentence(k));
		}
			return Integer.valueOf(holder.getTimes(k)).compareTo(holder.getTimes(j));
		});
	}

	public List<Integer> getTopHots() {
		return topHots;
	}

	public List<Integer> getTopSortedHots() {

		return topHots.stream().limit(3).collect(Collectors.toList());
	}

	public void setTopHots(List<Integer> topHots) {
		this.topHots = topHots;
	}

	public SearchTrie[] getSentence() {
		return sentence;
	}


}



class SentenceHolder {

	private Map<Integer,String> sentence;
	private Map<String,Integer> sentenceHolder;
	private Map<Integer,Integer> times;

	public SentenceHolder() {
		this.sentence = new HashMap<>();
		this.times = new HashMap<>();
		this.sentenceHolder = new HashMap<>();
	}

	public String getSentence(int id) {
		return sentence.get(id);
	}

	public void setSentence(String sentence, Integer id) {
		this.sentence.put(id,sentence);
	}

	public int getTimes(int id) {
		return times.get(id);
	}

	public void setTimes(int id,int time) {
		this.times.put(id,time);
	}

	public Integer getSentenceHolder(String sentence) {
		return sentenceHolder.get(sentence);
	}

	public void setSentenceHolder(String sentence, int id) {
		this.sentenceHolder.put(sentence,id);
	}
}
