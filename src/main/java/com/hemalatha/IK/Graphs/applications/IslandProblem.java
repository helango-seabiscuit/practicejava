package com.hemalatha.IK.Graphs.applications;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by helangovan on 2/25/17.
 */

//Given a map a 2D grid (0,1) count the number of islands in the grid
//   where 0 is water and 1 is land
//  considers not adjacent if cells are not diagonal
//Testcases
//1
//1
//        1 op: 1
//TC2
//3
//3
//        1 0 0
//        0 0 0
//        0 0 1  op:2
//TC3
//2
//3
//        1 1 0
//        0 0 1  op:1
//TC4
//2
//2
//        0 0
//        0 0   op:0
//TC5
//3
//1
//            1
//            1
//            1  op:1
//TC6
//3
//3
//        1 0 0
//        0 0 1
//        1 0 0  op:3
   class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i = i;
            this.j = j;
        }
        public String toString(){
            return "("+this.i+","+this.j+")";
        }
}

public class IslandProblem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = Integer.parseInt(in.nextLine().trim());
        int column = Integer.parseInt(in.nextLine().trim());
        int [][] grid = new int[row][column];
        for(int i=0;i<row;i++) {
            StringTokenizer st = new StringTokenizer(in.nextLine().trim());
            int j=0;
            while(st.hasMoreTokens()){
                grid[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println("No of islands - "+countIslands(grid));
    }

    public static int countIslands(int[][] grid){
        int lenI = grid.length;
        int lenJ = grid[0].length;
        int [][] visited = new int[lenI][lenJ];
        int count = 0;
        for(int i=0;i<lenI;i++){
            for(int j=0;j<lenJ;j++){
                if(grid[i][j]==1 && visited[i][j]!=1){
                    exhaust_cc(grid,i,j,visited);
                    count++;
                }
            }
        }
        return  count;
    }

    public static void exhaust_cc(int[][] grid,int i,int j,int[][] visited){
        if(visited[i][j]==1){
            return;
        }
        visited[i][j] = 1;
        for(Pair n :getNeighbours(grid,i,j)){
            exhaust_cc(grid,n.i,n.j,visited);
        }
    }

    public static List<Pair>  getNeighbours(int[][] grid,int i,int j){
        List<Pair> list = new ArrayList<>();
        Pair b = new Pair(i+1,j);
        Pair t = new Pair(i-1,j);
        Pair l = new Pair(i,j-1);
        Pair r = new Pair(i,j+1);
        List<Pair> possiblePairs = new ArrayList<>();
        possiblePairs.add(b);
        possiblePairs.add(t);
        possiblePairs.add(l);
        possiblePairs.add(r);

        for(Pair p: possiblePairs){
            if(0<=p.i && p.i<grid.length && 0<=p.j && p.j<grid[0].length && grid[p.i][p.j]==1){
                list.add(p);
            }
        }
        return  list;
    }
}
