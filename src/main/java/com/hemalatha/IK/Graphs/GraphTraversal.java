package com.hemalatha.IK.Graphs;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


class Vertex{
    int val;
    private Set<Vertex> neighbours;

    Vertex(int val){
        this.val = val;
        neighbours = new HashSet<>();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Set<Vertex> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Set<Vertex> neighbours) {
        this.neighbours = neighbours;
    }
}

public class GraphTraversal {

    static List<Vertex> vertices;

    public static void dfs(Vertex v,Set<Vertex> visited){
        if(visited.contains(v)){
            return;
        }
        visited.add(v);
        System.out.print(v+" ");
        for(Vertex s:v.getNeighbours()){
            dfs(s,visited);
        }
    }

    public static void bfs(Vertex v){
        Queue<Vertex> q = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        q.add(v);
        while (!q.isEmpty()){
            Vertex t = q.poll();
             if(visited.contains(v)){
                 continue;
             }
             visited.add(t);
            System.out.print(t.val+" ");
             for(Vertex s:v.getNeighbours()){
                 q.add(s);
             }
        }
    }

    public static void isCyclic(Vertex c){
        Set<Vertex> visited = new HashSet<>();
        Set<Vertex> path = new HashSet<>();
        for(Vertex v:vertices ) {
            if (!visited.contains(v)) {
              if(dfsCyclic(v, visited, path)){
                  System.out.println("Cyclic ");
                  break;
              }
        }
        }
    }

    public static boolean dfsCyclic(Vertex v,Set<Vertex> visited,Set<Vertex> path) {
        if (path.contains(v)) {
            //cycle
            return true;
        }
        if (visited.contains(v)) {
            return false;
        }
        visited.add(v);
        path.add(v);
        System.out.print(v + " ");
        for (Vertex s : v.getNeighbours()) {
            if (dfsCyclic(s, visited, path)) {
                return true;
            }
        }
        path.remove(v);
        return false;
    }

    //Problem statement:
    //Given a reference to a connected,undirected graph,verify it and return the reference to the new graph
    //Please hard code a graph input in your solution,clone it like the problem asks, compare clone to original graph and return a reference to the clone
    //Structure of each node of graphhas : a value and a list of neighbours
    //Edges are not directional and not weighted. We dont care about value of each node has
    //This is an exercise in cloning as well as traversing two graphs together(input and cloned),for comparison

    //Sample inputs to test with
    //Single node graph
    //Binary tree(Which is also a graph)
    //A linked list(which is also a graph)
    //a graph with a loop
    //clone the connected graph vertex where given a vertex
    //
    public static Collection<Vertex> cloneGraph(List<Vertex> vertices){
        Set<Vertex> visited = new HashSet<>();
        Map<Vertex,Vertex> cloneMap = new HashMap<>();
        for(Vertex v: vertices){
            if(!cloneMap.containsKey(v)){
                clone(v,cloneMap);
            }
        }
        return cloneMap.values();
    }
     public  static Vertex clone(Vertex v,Map<Vertex,Vertex> cloneMap){
         if(cloneMap.containsKey(v)){
             return cloneMap.get(v);
         }
         Vertex cloneV = new Vertex(v.val);
         cloneMap.put(v,cloneV);
          Set<Vertex> neighbours = new HashSet<>();

         for(Vertex s:v.getNeighbours()){
            neighbours.add(clone(s,cloneMap));
         }
         cloneV.setNeighbours(neighbours);
         return cloneV;
     }
}
