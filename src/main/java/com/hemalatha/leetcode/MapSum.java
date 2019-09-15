package com.hemalatha.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

	public static void main(String[] args) {
		MapSum sum = new MapSum();
		sum.insert("apple",3);
		System.out.println(sum.sum("ap"));//3
		sum.insert("app",2);
		System.out.println(sum.sum("ap"));//5
	}

	/** Initialize your data structure here. */
	private TNode root;
	public MapSum() {
     this.root = new TNode();
	}

	public void insert(String key, int val) {
      TNode curr = root;
      for(int i=0;i<key.length();i++){
      	char c = key.charAt(i);
      	if(curr.getChild(c)==null){
      		curr.setChild(c);
		}
		curr = curr.getChild(c);
		int v = curr.getValue();
      	curr.setValue(v+val);
	  }

	}

	public int sum(String prefix) {

		TNode curr = root;
		for(int i=0;i<prefix.length();i++){
			char c = prefix.charAt(i);
			if(curr.getChild(c)==null){
				return -1;
			}
			curr = curr.getChild(c);
		}
		return curr.getValue();
	}
}

class TNode{
	private int value;

	private Map<Character,TNode> children;

	public TNode() {
		this.children = new HashMap<>();

	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TNode getChild(Character c) {
		return children.get(c);
	}

	public void setChild(Character c) {
		this.children.put(c,new TNode());
	}
}
