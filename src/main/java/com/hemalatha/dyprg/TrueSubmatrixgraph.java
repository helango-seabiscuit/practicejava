package com.hemalatha.dyprg;

import static org.junit.Assert.*;

public class TrueSubmatrixgraph {


	public static void main(String[] args) {
     int[][] arr = new int[][]{{1,0,1,0},{1,1,1,0},{1,1,1,0}};
		assertEquals(2 , biggestTrueMatrix(arr));
		assertEquals(2 , maxSubMatrixBottomUp(arr));

		arr = new int[][]{{1,1,1,0},{1,1,1,0},{1,1,1,0}};
		assertEquals(3 , biggestTrueMatrix(arr));
		assertEquals(3 , maxSubMatrixBottomUp(arr));
		arr = new int[][]{{0,0,1,0},{1,0,1,0},{1,1,1,0}};
		assertEquals(1 , biggestTrueMatrix(arr));
		assertEquals(1 , maxSubMatrixBottomUp(arr));
		arr = new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		assertEquals(0 , biggestTrueMatrix(arr));
		assertEquals(0 , maxSubMatrixBottomUp(arr));

	}

	public static int biggestTrueMatrix(int[][] arr){
		int dp[][] = new int[arr.length][arr[0].length];
		int max = 0;
		for(int i=0;i< arr.length;i++){
			for (int j=0;j<arr[0].length;j++){
				//max = Math.max(biggestTrueMatrixRec(arr,i,j),max);
				max = Math.max(biggestTrueMatrixRecdp(arr,i,j,dp),max);
			}
		}
		return max;
	}

	public static int biggestTrueMatrixRec(int [][]arr,int i,int j){
		if(i==arr.length || j== arr[0].length || arr[i][j]==0){
			return 0;
		}

		return 1+Math.min(Math.min(biggestTrueMatrixRec(arr,i+1,j),biggestTrueMatrixRec(arr,i,j+1)),
				biggestTrueMatrixRec(arr,i+1,j+1));
	}

	public static int biggestTrueMatrixRecdp(int [][]arr,int i,int j, int[][]dp){
		if(i==arr.length || j== arr[0].length || arr[i][j]==0){
			return 0;
		}
		if(dp[i][j] == 0) {

			dp[i][j] = 1 + Math.min(Math.min(biggestTrueMatrixRec(arr, i + 1, j), biggestTrueMatrixRec(arr, i, j + 1)),
					biggestTrueMatrixRec(arr, i + 1, j + 1));
		}
		return dp[i][j];
	}

	public static int maxSubMatrixBottomUp(int [][]arr){
		int dp[][] = new int[arr.length][arr[0].length];
		int max = 0;
        for(int i=0;i<dp.length;i++){
        	for (int j=0;j<dp[0].length;j++){
        		if(i==0 || j==0){
        			dp[i][j] = arr[i][j] ==0? 0:1;
				}
        		else if (arr[i][j]==1){
        			dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]) +1;
				}
				max = Math.max(max,dp[i][j]);
			}
		}
		return max;
	}
}
