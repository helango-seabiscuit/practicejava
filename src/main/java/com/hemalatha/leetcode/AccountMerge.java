package com.hemalatha.leetcode;

import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AccountMerge {

	public static void main(String[] args) {

		List<List<String >> input = new ArrayList<>();
		List<String> l1 = new ArrayList<>();
		l1.add("John");
		l1.add("johnsmith@mail.com");
		l1.add("john00@mail.com");
		List<String> l2 = new ArrayList<>();
		l2.add("John");
		l2.add("johnnybravo@mail.com");

		List<String> l3 = new ArrayList<>();
		l3.add("John");
		l3.add("johnsmith@mail.com");
		l3.add("john_newyork@mail.com");

		List<String> l4 = new ArrayList<>();
		l4.add("Mary");
		l4.add("mary@mail.com");

		input.add(l1);
		input.add(l2);
		input.add(l3);
		input.add(l4);
		System.out.println(accountsMerge(input));
		//putInSet(input);
	}


	public static  List<List<String>> accountsMerge(List<List<String>> accounts) {
		HashMap<String,Integer> emailToId = new HashMap<>();
		HashMap<String,String> emailToName = new HashMap<>();
		int id=0;
		DSU dsu = new DSU(10);
		for(List<String> list:accounts){

			String name = null;
			for(String email:list){
				if(Strings.isNullOrEmpty(name)){
					name = email;
					continue;
				}

				if(!emailToId.containsKey(email)){
					emailToId.put(email,id++);
				}
				emailToName.put(email,name);
				dsu.union(emailToId.get(list.get(1)),emailToId.get(email));
			}

		}

		Map<Integer,List<String>> emailSets = new HashMap<>();
		for( String e: emailToId.keySet()){

			int index = dsu.find(emailToId.get(e));
			emailSets.computeIfAbsent(index,(v)->new ArrayList<String>()).add(e);
		}


		List<List<String>> result = new ArrayList<>();
		for(List<String> l:emailSets.values()){
			Collections.sort(l);
			l.add(0,emailToName.get(l.get(0)));
			result.add(l);
		}

		return result;

	}

	public static  void putInSet(List<List<String>> emails){
		HashMap<String,Integer> emailToId = new HashMap<>();
		HashMap<String,String> emailToName = new HashMap<>();
		int id=0;
		DSU dsu = new DSU(10);
		for(List<String> list:emails){

			String name = null;
			for(String email:list){
				if(Strings.isNullOrEmpty(name)){
					name = email;
					continue;
				}

				if(!emailToId.containsKey(email)){
					emailToId.put(email,id++);
				}
				emailToName.put(email,name);
				dsu.union(emailToId.get(list.get(0)),emailToId.get(email));
			}

		}

		Map<Integer,List<String>> emailSets = new HashMap<>();
		for( String e: emailToId.keySet()){

			int index = dsu.find(emailToId.get(e));
			emailSets.computeIfAbsent(index,(v)->new ArrayList<String>()).add(e);
		}


		List<List<String>> result = new ArrayList<>();
		for(List<String> l:emailSets.values()){
			Collections.sort(l);
			l.add(0,emailToName.get(l.get(0)));
			result.add(l);
		}

	}
}

 class DSU{

	private int n[];

	DSU(int size ){
		n = new int[size];
		for(int i=0;i<size;i++){
			n[i]=i;
		}
	}

	 public int[] getN() {
		 return n;
	 }

	 public int find(int x){
		if(n[x] != x){
			return  find(n[x]);
		}
		return n[x];
	}

	public void union(int x,int y){
		if(find(x) != find(y)){
			n[find(x)] = find(y);
		}
	}

		}
