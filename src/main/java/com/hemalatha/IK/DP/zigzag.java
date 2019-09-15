package com.hemalatha.IK.DP;

import java.util.Arrays;

/**
 * Created by helangovan on 4/1/17.
 */
public class zigzag {

    public static void main(String[] args) {
       // int [] num = new int[]{1,7,4,9,2,5};
        int [] num = new int[]{1,17,5,10,13,15,10,5,16,8};
        int [] wt = new int[num.length];
        char [] sign = new char[num.length];

        wt[0] = 1;
        wt[1] = 2;
        sign[1] = num[1]-num[0]<0?'-':'+';
        for(int i=2;i<num.length;i++){
            wt[i] = 1;
            for(int j=i-1;j>=0;j--){
              int diff = num[i] - num[j];
                char sig = sign[j];
                if(diff>0){
                    if(sig =='-'){
                        if(wt[j]+1>wt[i]){
                            wt[i] = wt[j]+1;
                            sign[i]='+';
                        }
                    }
                }else if(diff<0){
                    if(sig =='+'){
                        if(wt[j]+1>wt[i]){
                            wt[i] = wt[j]+1;
                            sign[i]='-';
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(wt));
    }
}
