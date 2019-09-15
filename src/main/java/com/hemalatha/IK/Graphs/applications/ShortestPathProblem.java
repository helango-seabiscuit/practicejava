package com.hemalatha.IK.Graphs.applications;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by helangovan on 2/25/17.
 */
//using Dijkstra algorithm
public class ShortestPathProblem {

    public static void main(String[] args) {

    }

    public  static  void  dijkstra(Vertex v){
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        Map<Vertex,Integer> distances = new HashMap<>();
        while (!queue.isEmpty()){
            Vertex q = queue.poll();
             Integer dist = distances.get(v);
            for(Vertex n:q.getNeighbours()){
                int newDist;

                if(dist==null){
                  newDist = n.weight;
                }else {
                    newDist = Math.min(dist, dist + n.weight);

                }
                distances.put(n, newDist);
                n.weight = newDist;
            }

        }
    }
}
