package com.hemalatha.IK.DP;

/**
 * Created by helangovan on 4/3/17.
 */
public class LevenshSteinDP {


    static int levenshteinDistance(String strWord1, String strWord2) {
        char[] sr = strWord1.toCharArray();
        char [] t = strWord2.toCharArray();
        int m = strWord1.length();
        int n = strWord2.length();

        if(m==0){
            return n;
        }
        if(n==0){
            return m;
        }

        int[][] ld = new int[n][m];
        for(int i=0;i<m;i++){
            int cost=1;
            if(sr[i]==t[0]){
                cost=0;
            }
            if(i==0){
                ld[0][i]=cost;
                continue;
            }
            ld[0][i] = ld[0][i-1]+cost;
        }
        for(int j=0;j<n;j++){
            int cost=1;
            if(sr[0]==t[j]){
                cost=0;
            }
            if(j==0){
                ld[j][0]=cost;
                continue;
            }
            ld[j][0] = ld[j-1][0]+cost;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                int cost =1;
                if(sr[j]==t[i]){
                    cost=0;
                }
                int top =  ld[i-1][j]+1;
                int left = ld[i][j-1]+1;
                int dg = ld[i-1][j-1]+cost;

                ld[i][j] = Math.min(Math.min(top,left),dg);
            }
        }
        return ld[n-1][m-1];

    }
}
