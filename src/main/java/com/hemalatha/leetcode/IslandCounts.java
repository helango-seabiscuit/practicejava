package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IslandCounts {

	public static void main(String[] args) {
		IslandCounts counts = new IslandCounts();
		System.out.println(counts.numIslands(new char[][]{{'1', '1', '1'}}));//1
		System.out.println(counts.numIslands(new char[][]{{'1', '1', '1', '1', '0'},
														  {'1', '1', '0', '1', '0'},
														  {'1', '1', '0', '0', '0'},
														  {'0', '0', '0', '0', '0'}}));//1
		System.out.println(counts.numIslands(new char[][]{{'1','1','0','0','0'},
			                                              {'1','1','0','0','0'},
														  {'0','0','1','0','0'},
														  {'0','0','0','1','1'}}));//3

	}

	public int numIslands(char[][] grid) {

		if(grid == null || grid.length ==0){
			return 0;
		}

		int row = grid.length;
		int col = grid[0].length;

		int count = 0;
		boolean [][] visited = new boolean[row][col];
		for (int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(grid[i][j] =='1' && visited[i][j]==false) {
				//	bfs(i,j,row,col,grid,visited);
					dfs(i,j,row,col,grid,visited);
					count++;
				}
			}
		}

		return count;
	}


	public void dfs(int i,int j,int row,int col,char[][]grid,boolean[][]visited){
		if(visited[i][j]){
			return;
		}
		visited[i][j]=true;
		for(int[] p:getNeighbours(i,j,row,col,grid)){
			if(visited[p[0]][p[1]]==false){
				dfs(p[0],p[1],row,col,grid,visited);
			}
		}
	}

	public List<int[]> getNeighbours(int i, int j, int row, int col, char[][]grid){
		List<int[]> res = new ArrayList<>();
		if(i-1>=0 && grid[i-1][j]=='1' ){
			res.add(new int[]{i-1,j});
		}
		if(i+1<row && grid[i+1][j]=='1' ){
			res.add(new int[]{i+1,j});
		}
		if(j-1>=0 && grid[i][j-1]=='1' ){
			res.add(new int[]{i,j-1});
		}
		if(j+1<col && grid[i][j+1]=='1' ){
			res.add(new int[]{i,j+1});
		}
		return res;
	}

	public void bfs(int i,int j,int row,int col,char[][]grid, boolean[][]visited){
		Queue<int[]> queue = new LinkedList();

		queue.add(new int[]{i,j});
		while (!queue.isEmpty()){
			int[] p = queue.poll();
			visited[p[0]][p[1]] = true;

			if(p[0]+1<row && visited[p[0]+1][p[1]]==false && grid[p[0]+1][p[1]]=='1'){
				queue.add(new int[]{p[0]+1,p[1]});
			}

			if(p[0]-1>=0 && visited[p[0]-1][p[1]]==false && grid[p[0]-1][p[1]]=='1'){
				queue.add(new int[]{p[0]-1,p[1]});
			}
			if(p[1]+1<col && visited[p[0]][p[1]+1]==false && grid[p[0]][p[1]+1]=='1'){
				queue.add(new int[]{p[0],p[1]+1});
			}
			if(p[1]-1>=0 && visited[p[0]][p[1]-1]==false && grid[p[0]][p[1]-1]=='1'){
				queue.add(new int[]{p[0],p[1]-1});
			}
		}
	}
}
