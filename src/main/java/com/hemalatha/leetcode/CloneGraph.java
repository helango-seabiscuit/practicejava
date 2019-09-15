package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CloneGraph {

	public static void main(String[] args) {

	}


	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
       return dfs(node,new HashSet<>(),new HashMap<>());
	}

	public UndirectedGraphNode dfs(UndirectedGraphNode node, Set<UndirectedGraphNode> visited, Map<Integer,UndirectedGraphNode> map){
		if(visited.contains(node)){
			return map.get(node.label);
		}
		visited.add(node);
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		map.put(newNode.label,newNode);
		for(UndirectedGraphNode n:node.neighbors){
			  newNode.neighbors.add(dfs(n, visited, map));

		}

		return newNode;

	}
}

class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
  };