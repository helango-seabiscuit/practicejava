package com.hemalatha.leetcode;


//https://leetcode.com/problems/implement-trie-prefix-tree/description/
/**
 *
 * Implement a trie with insert, search, and startsWith methods.

 Example:

 Trie trie = new Trie();

 trie.insert("apple");
 trie.search("apple");   // returns true
 trie.search("app");     // returns false
 trie.startsWith("app"); // returns true
 trie.insert("app");
 trie.search("app");     // returns true

 Note:

 You may assume that all inputs are consist of lowercase letters a-z.
 All inputs are guaranteed to be non-empty strings.


 */
class Trie {


	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("app");
		//System.out.println(trie.search("apple"));   // returns true
		System.out.println(trie.search("app"));     // returns false
		//System.out.println(trie.startsWith("app"));       // returns true
		trie.insert("apple");
		System.out.println(trie.search("app"));    // returns true
		System.out.println(trie.search("apple"));    // returns true
	}

	private LetterNode root;

	/** Initialize your data structure here. */
	public Trie() {
		this.root = new LetterNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		LetterNode temp = this.root;
		char wordChar [] = word.toCharArray();
		for(int i=0;i<wordChar.length;i++){
			temp = temp.add(wordChar[i],i == wordChar.length-1);
		}
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		  LetterNode temp = root;
		  for(int i=0;i<word.length();i++){
		  	temp = temp.get(word.charAt(i));
		  	if(temp == null){
		  		return false;
			}
		  }
          return temp.isLeaf();
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		LetterNode temp = root;
		for(int i=0;i<prefix.length();i++){
			temp = temp.get(prefix.charAt(i));
			if(temp == null){
				return false;
			}
		}
       return true;
	}
}

class LetterNode{

	LetterNode[] nodes = new LetterNode[26];

	boolean isLeaf;

	public LetterNode() {
		this.isLeaf = false;
	}

	public void setLeaf(boolean leaf) {
		isLeaf = leaf;
	}

	public LetterNode[] getNodes() {
		return nodes;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public LetterNode add(char c, boolean isLeaf){
		if(this.nodes[c-'a'] == null){
			this.nodes[c-'a'] = new LetterNode();
		}

		this.nodes[c-'a'].isLeaf =this.nodes[c-'a'].isLeaf ? true:isLeaf;
		return this.nodes[c-'a'];
	}

	public LetterNode get(char c){
		return this.nodes[c-'a'];
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */