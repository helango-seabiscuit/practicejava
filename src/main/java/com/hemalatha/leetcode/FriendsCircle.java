package com.hemalatha.leetcode;

import java.util.HashSet;
import java.util.Set;


//https://leetcode.com/problems/friend-circles/solution/#
public class FriendsCircle {

	private int parent[];
	public int findCircleNum(int[][] M) {
		int n = M.length;
		parent = new int[n];
		for(int i=0;i<n;i++){
			parent[i] = i;
		}

		for(int i=0;i< n;i++){
			for(int j=0;j<n;j++){
				if(M[i][j] ==1){
					union(i,j);
				}
			}
		}

		Set<Integer> res = new HashSet<>();
		for(int i=0;i<n;i++){
			res.add(find(i));
		}
        return res.size();
	}

	public void union(int a,int b){
		if(find(a) != find(b)){
			parent[find(a)] = find(b);
		}
	}

	public int find(int a){
		if(parent[a] != a){
			return find(parent[a]);
		}
		return parent[a];
	}
}
