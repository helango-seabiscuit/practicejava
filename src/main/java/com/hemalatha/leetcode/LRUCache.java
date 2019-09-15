package com.hemalatha.leetcode;

import java.util.HashMap;

public class LRUCache {

	public static void main(String[] args) {


		LRUCache obj = new LRUCache(2);
        obj.put(2,1);
        obj.put(1,1);
        obj.put(2,3);
        obj.put(4,1);
		System.out.println(obj.get(1));
		System.out.println(obj.get(2));
	}

	private HashMap<Integer,CacheNode> cache;
	private CacheNode head,tail;
	private int capacity;
	private int currSize;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<>();
	}

	public int get(int key) {
       if(cache.get(key) == null){
       	return -1;
	   }
	   CacheNode res = cache.get(key);
       addToTail(res);
       return res.getValue();
	}

	public void put(int key, int value) {
		if(cache.get(key)!=null){
			CacheNode node = cache.get(key);
			node.setValue(value);
			addToTail(node);
			return;
		}
		CacheNode node = new CacheNode(key,value);
		if(currSize >= this.capacity ) {
			removeLeastCached();
		}
		currSize++;
		addToTail(node);
		cache.put(key,node);

	}

	public void addToTail(CacheNode node){
		if(this.tail == null){
			this.head = node;
			this.tail = node;
		}else {
			if(tail != node) {
				if (node.previous != null) {
					node.previous.next = node.next;
				}
				if (node.next != null) {
					node.next.previous = node.previous;
				}
				if(node == head){
					head = node.next;
				}
				node.previous = tail;
				node.next = tail.next;
				tail.next = node;
				tail = node;
			}
		}
	}

	public void removeLeastCached(){
		if(head != null){
			CacheNode removed = head;
			if(head == tail){
				head = tail = null;
			}else{
				head = removed.next;
				if(removed.previous != null){
					removed.previous.next = removed.next;
				}
			}
			cache.remove(removed.getKey());
			this.currSize--;
		}
	}
}

class CacheNode {

	private int key;
	private  int value;
	CacheNode next,previous;

	public CacheNode(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public CacheNode getNext() {
		return next;
	}

	public void setNext(CacheNode next) {
		this.next = next;
	}

	public CacheNode getPrevious() {
		return previous;
	}

	public void setPrevious(CacheNode previous) {
		this.previous = previous;
	}
}
