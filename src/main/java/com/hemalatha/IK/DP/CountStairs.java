package com.hemalatha.IK.DP;

/**
 * Created by helangovan on 4/11/17.
 */
public class CountStairs {

    static int numWaysToClimb(int[] numSteps, int numStairs) {
        int res = 0;
        int [] r = new int[numStairs+1];
        int lastNumber = numSteps[numSteps.length-1];
        r[0]=0;

        for (int j=1; j<=numStairs; j++){
            r[j] = 0;
            for(int k=0;k<numSteps.length && j>=numSteps[k] ;k++){
                int ext=0;
                if(j==numSteps[k]){
                    ext=1;
                }
                r[j] += r[j-numSteps[k]]+ext;
            }
        }
        return r[numStairs];

    }

    public static void main(String[] args) {

      //  System.out.println(numWaysToClimb());
    }
}
