package com.hemalatha.IK.DP;

/**
 * Created by helangovan on 4/1/17.
 */
public class BasicCoinProblem {

    public static void main(String[] args) {
        int sum =11;
        int coins[] = new int[]{1,3,5};
        int min[] = new int[sum+1];
        for(int i=0;i<=sum;i++){
            min[i] = Integer.MAX_VALUE;
        }
        min[0]=0;
        for(int i=1;i<=sum;i++){
            for(int j=0;j<coins.length;j++){
                 if(coins[j]<=i && min[i-coins[j]]+1<min[i]){
                     min[i] = min[i-coins[j]]+1;
                 }
            }
        }
        System.out.println(min[sum]);
    }
}
