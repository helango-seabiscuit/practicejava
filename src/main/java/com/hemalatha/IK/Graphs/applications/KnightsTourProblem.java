package com.hemalatha.IK.Graphs.applications;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by helangovan on 2/26/17.
 */
public class KnightsTourProblem {

    static class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    static int minimumMoves(int rows, int cols, int startx, int starty, int endx, int endy) {
        int [] [] visited = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        return countMovesBfs(visited,startx,starty,endx,endy);
    }

    public static int countMovesBfs(int[][] visited,int startx,int starty,int endx,int endy){
        int count=0;
        visited[startx][starty] = 1;
        Queue<Pair> queue = new LinkedList<>();
        Pair p = new Pair(startx,starty);
        Pair dummy = new Pair(-1,-1);
        queue.add(p);
        queue.add(dummy);
        while(!queue.isEmpty()){
            Pair v = queue.poll();
            if(v.i==-1 && v.j==-1){
                if(!queue.isEmpty()){
                    queue.add(dummy);
                    count++;
                }
                continue;
            }
            for(Pair pr:getNeighbours(v.i,v.j,visited)){
                if(visited[pr.i][pr.j] ==Integer.MAX_VALUE){
                    visited[pr.i][pr.j]=count+1;
                    queue.add(pr);
                }
                if(pr.i==endx && pr.j==endy){
                    return visited[pr.i][pr.j];
                }
            }

        }
        return 0;
    }

    public static List<Pair> getNeighbours(int i, int j, int[][] visited){
        List<Pair> adjPairs = new ArrayList<>();
        Pair p1 = new Pair(i-1,j-2);
        Pair p2 = new Pair(i-1,j+2);
        Pair p3 = new Pair(i+1,j-2);
        Pair p4 = new Pair(i+1,j+2);
        Pair p5 = new Pair(i+2,j-1);
        Pair p6 = new Pair(i+2,j+1);
        Pair p7 = new Pair(i-2,j-1);
        Pair p8 = new Pair(i-2,j+1);
        adjPairs.add(p1);
        adjPairs.add(p2);
        adjPairs.add(p3);
        adjPairs.add(p4);
        adjPairs.add(p5);
        adjPairs.add(p6);
        adjPairs.add(p7);
        adjPairs.add(p8);
        List<Pair> result = new ArrayList<>();
        for(Pair p:adjPairs){
            if(0<=p.i && p.i<visited.length && 0<=p.j && p.j<visited[0].length){
                result.add(p);
            }
        }
        return result;
    }

}
