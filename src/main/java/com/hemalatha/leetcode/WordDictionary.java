package com.hemalatha.leetcode;

public class WordDictionary {


	private AlphabetNode root = new AlphabetNode();
	/** Initialize your data structure here. */
	public WordDictionary() {

	}


	public static void main(String[] args) {
		WordDictionary dictionary = new WordDictionary();
//		dictionary.addWord("bad");
//		dictionary.addWord("dad");
//		dictionary.addWord("mad");
//		System.out.println(dictionary.search("pad"));// false
//		System.out.println(dictionary.search("bad"));// -> true
//		System.out.println(dictionary.search(".ad"));// -> true
//		System.out.println(dictionary.search("b.."));// -> true

		dictionary.addWord("at");
		dictionary.addWord("and");
		dictionary.addWord("an");
		dictionary.addWord("add");
		System.out.println(dictionary.search("a"));// false
		System.out.println(dictionary.search(".at"));// false
		dictionary.addWord("bat");
		System.out.println(dictionary.search(".at"));// false
		System.out.println(dictionary.search("an."));// false
		System.out.println(dictionary.search("a.d."));// false
		System.out.println(dictionary.search("b."));// false
		System.out.println(dictionary.search("a.d"));// false
		System.out.println(dictionary.search("."));// -> true
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		AlphabetNode temp = root;
		char c[] = word.toCharArray();
        for(int i=0;i<c.length;i++){
        	temp = temp.add(c[i],i==c.length -1 ? true:false);
		}
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		return search(word,-1,root);
	}

	private boolean search(String word, int idx, AlphabetNode node){
		if( node != null && node.isLeaf && idx == word.length()-1){
			return true;
		} else if (idx == word.length() -1 || node == null){
			return false;
		}

		char c = word.charAt(idx+1);
		if(Character.isAlphabetic(c)){
			node = node.get(c);
			return  search(word,idx+1,node);
		}else {
			for(int i =0;i<26;i++){
				if(node.nodes[i] != null) {
					if (search(word, idx + 1, node.nodes[i])){
						return true;
					}
				}
			}
		}
		return false;
	}
}

class AlphabetNode{

	AlphabetNode[] nodes = new AlphabetNode[26];

	boolean isLeaf;

	public AlphabetNode() {
		this.isLeaf = false;
	}

	public void setLeaf(boolean leaf) {
		isLeaf = leaf;
	}

	public AlphabetNode[] getNodes() {
		return nodes;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public AlphabetNode add(char c, boolean isLeaf){
		if(this.nodes[c-'a'] == null){
			this.nodes[c-'a'] = new AlphabetNode();
		}

		this.nodes[c-'a'].isLeaf =this.nodes[c-'a'].isLeaf ? true:isLeaf;
		return this.nodes[c-'a'];
	}

	public AlphabetNode get(char c){
		return this.nodes[c-'a'];
	}
}

