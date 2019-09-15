package com.hemalatha.IK.Graphs.applications;


//Given an elevation map each cell represents elevation at a particular point in land. What happens when there is rainfall?
//Water from each cell will flow to its lowest adjacent cell
//sink - a cell where water cannot flow  anywhere else
//basin  - all pieces of land where water flows into sink
//index of sink water finally flows
//adjacency is all eight of the cells
//Identify the basin for every cell in the given grid

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RainFallReserveProblem {

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
        Pair[][] sinkCells = new Pair[row][column];
        findSinks(grid,sinkCells);
        printSinks(sinkCells);

    }

    public static void printSinks(Pair[][] sinkCells){
        for(int i=0;i<sinkCells.length;i++){
            for(int j=0;j<sinkCells[0].length;j++){
                System.out.print(sinkCells[i][j]+" ");
            }
            System.out.println();
        }
    }

    public  static void findSinks(int[][] grid,Pair [][] sinkCells){

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(sinkCells[i][j]==null){
                  findSink(grid,i,j,sinkCells);
                }
            }
        }
    }

    public static Pair findSink(int[][] grid,int i,int j,Pair[][] sinkCells){
       if(sinkCells[i][j]!=null){
           return sinkCells[i][j];
       }
        List<Pair> neighbours = getNeighbours(grid,i,j);

        Pair minNeighbour = null;
        int minElev = Integer.MAX_VALUE;
        for(Pair p:neighbours){
            int elevation = grid[p.i][p.j];
            if(elevation<minElev){
                minElev = elevation;
                minNeighbour = p;
            }
        }
        if(grid[i][j]<minElev){
            return  sinkCells[i][j] = new Pair(i,j); //assign itself and then return
        }
        return sinkCells[i][j] = findSink(grid,minNeighbour.i,minNeighbour.j,sinkCells);

    }

    public static List<Pair> getNeighbours(int[][] grid,int i,int j){
        List<Pair> res = new ArrayList<>();
        Pair p1 = new Pair(i-1,j);
        Pair p4 = new Pair(i-1,j+1);
        Pair p5 = new Pair(i-1,j-1);
        Pair p3 = new Pair(i,j-1);
        Pair p6 = new Pair(i,j+1);
        Pair p2 = new Pair(i+1,j);
        Pair p7 = new Pair(i+1,j-1);
        Pair p8 = new Pair(i+1,j+1);


        List<Pair> adjList = new ArrayList<>();
        adjList.add(p1);
        adjList.add(p2);
        adjList.add(p3);
        adjList.add(p4);
        adjList.add(p5);
        adjList.add(p6);
        adjList.add(p7);
        adjList.add(p8);

        for(Pair p:adjList){
            if(0<=p.i && p.i<grid.length && 0<=p.j && p.j<grid[0].length){
                res.add(p);
            }
        }
        return res;
    }


}
