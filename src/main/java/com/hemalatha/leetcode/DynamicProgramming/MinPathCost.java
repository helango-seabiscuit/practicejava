package com.hemalatha.leetcode.DynamicProgramming;

public class MinPathCost {

	public static void main(String[] args) {
		MinPathCost pathCost = new MinPathCost();
		System.out.println(pathCost.minPath(new int[][]{{1,3,5,8},
														{4,2,1,7},{4,3,2,3}},0,0));

		System.out.println(pathCost.minPathTopDP(new int[][]{{1,3,5,8},
														{4,2,1,7},{4,3,2,3}},3,4));
	}

	public int minPath(int cost[][],int i,int j){
		if(i>=cost.length || j>=cost[0].length){
			return -1;
		}
		if(i==cost.length-1 && j==cost[0].length-1){
			return cost[i][j];
		}

		int r = minPath(cost,i,j+1);
		int d = minPath(cost,i+1,j);

		if(r!= -1 && d != -1){
			return Math.min(r,d)+cost[i][j];
		}

		return r!= -1? r + cost[i][j]: d + cost[i][j];
	}

	public int minPathTopDP(int[][] cost,int m,int n){

		for(int i=0;i<m;i++){
			for (int j=0;j<n;j++){
				if(j==0 && i==0){
					continue;
				}
				else if(j==0){
					cost[i][j]+=cost[i-1][j];
				}
				else if(i==0){
					cost[i][j]+=cost[i][j-1];
				}else {
					cost[i][j]+=Math.min(cost[i-1][j],cost[i][j-1]);
				}
			}
		}

		return cost[m-1][n-1];

	}
}
