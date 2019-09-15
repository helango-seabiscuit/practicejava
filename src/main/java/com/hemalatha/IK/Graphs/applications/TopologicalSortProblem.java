package com.hemalatha.IK.Graphs.applications;




import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//given various courses and the courses each depend on before learning the course
//can use topological sort to find the prerequisites of a course or all courses
//can be solved only if there are no cycles

class Vertex{
    int val;
    int weight;
    private Set<Vertex> neighbours;

    Vertex(int val){
        this.val = val;
        neighbours = new HashSet<>();
    }
    Vertex(int val,int weight){
        this.val = val;
        this.weight = weight;
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

public class TopologicalSortProblem {

    public static void main(String[] args) {

    }

    public static void topologicalSort(Vertex[] list){
        Set<Vertex> visited = new HashSet<>();
        Stack<Vertex> res = new Stack<>();
        for (Vertex v:list){
            if(!visited.contains(v)){
               dfs(v,visited,res);
            }
        }

        while (!res.isEmpty()){
            System.out.print( res.pop().getVal()+" ");
        }
    }

    public static void dfs(Vertex v,Set visited,Stack result){
        if(visited.contains(v)){
            return;
        }
        visited.add(v);
        for(Vertex q:v.getNeighbours()){
            dfs(q,visited,result);
        }
        result.push(v);
    }
}
