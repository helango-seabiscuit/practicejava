package com.hemalatha.leetcode.DynamicProgramming;

public class LCS {


	private int[][] mat;
	public static void main(String[] args) {

		//String s1="AAACCGTGAGTTATTCGTTCAGAA";
		//String s2="CACCCCTAAGGTACCTTTGGTTC";
		String s1="AEBD";
		String s2="ABCD";
		LCS lcs = new LCS(s1.length(),s2.length());
		System.out.println(lcs.LCSRecMem(s1,s2,0,0));
		System.out.println(lcs.LCSRec(s1,s2,0,0));
		System.out.println(lcs.LCSDP(s1,s2));

	}

	public LCS(int m,int n){
		this.mat = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				this.mat[i][j]=-1;
			}
		}
	}

	public int LCSDP(String s1,String s2){
		int m = s1.length();
		int n = s2.length();
		int[][] LCSCount = new int[m+1][n+1];


		for(int i=0;i<=m;i++){
			LCSCount[i][0]=0;
		}

		for(int j=0;j<=n;j++){
			LCSCount[0][j]=0;
		}

		for(int i=1;i<=m;i++){
			for (int j=1;j<=n;j++){
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					LCSCount[i][j] = LCSCount[i-1][j-1]+1;
				}else{
					LCSCount[i][j] = Math.max(LCSCount[i-1][j],LCSCount[i][j-1]);
				}
			}
		}

		printLCS(LCSCount,s1,s2);
		return LCSCount[m][n];
	}

	public void printLCS(int[][]dp,String s1,String s2){
		int m = dp.length;
		int n = dp[0].length;

		int i=m-1;
		int j=n-1;
		StringBuilder sb = new StringBuilder();
		while (i>0 && j>0){
			if(s1.charAt(i-1)==s2.charAt(j-1)){
				sb.append(s1.charAt(i-1));
				i--;
				j--;
			}else if(dp[i-1][j]>dp[i][j-1]){
				i--;
			}else{
				j--;
			}
		}

		System.out.println(sb.reverse().toString());
	}

	public int LCSRec(String s1, String s2,int i,int j){
		if(i>=s1.length() || j>=s2.length()) {
			return 0;
		}



		if(s1.charAt(i)==s2.charAt(j)){
			return LCSRec(s1,s2,i+1,j+1)+1;
		}
         else {
			return Math.max(LCSRec(s1, s2, i, j +1), LCSRec(s1, s2, i +1, j));
		}

	}


	public int LCSRecMem(String s1, String s2,int i,int j){
//		if(i==0 || j==0){
//			return 0;
//		}

		if(i>=s1.length() || j>=s2.length()) {
			return 0;
		}

		if(mat[i][j]!=-1){
			return mat[i][j];
		}

		if(s1.charAt(i)==s2.charAt(j)){
			mat[i][j]= LCSRecMem(s1,s2,i+1,j+1)+1;
		}
		else {
			mat[i][j]= Math.max(LCSRecMem(s1, s2, i, j +1), LCSRecMem(s1, s2, i +1, j));
		}
		return mat[i][j];
	}
}
