package com.hemalatha.IK.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by helangovan on 2/22/17.
 */

//given set of integers find contiguous subset whose sum is zero

public class SumZeroArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine().trim());
        int [] intArr = new int[size];
        StringTokenizer st = new StringTokenizer(in.nextLine().trim());
        int i=0;
        while(st.hasMoreTokens()){
            intArr[i++] = Integer.parseInt(st.nextToken().trim());
        }
        String res[][] = sumZeroAllArr(intArr);
        for(int j=0;j<res.length;j++){
            System.out.println(Arrays.deepToString(res[j]));
        }
    }


    static String[] sumZero(int[] intArr) {
        Map<Integer,Integer> sumMap = new HashMap<>();
        int sum=0;
        int startIndex=-1;
        int endIndex = -1;
        String[] res;
        for(int i=0;i<intArr.length;i++){
            sum+=intArr[i];
            if(sumMap.containsKey(sum)){
                startIndex = sumMap.get(sum)+1;
                endIndex = i;
                break;
            }
            sumMap.put(sum,i);
        }

        if(startIndex!=-1){
            res = new String[endIndex-startIndex+2];
            for(int i=startIndex;i<=endIndex;i++){
                res[i] = String.valueOf(intArr[i]);
            }
        }else{
            res = new String[]{"0"};
        }

        return res;
    }

    static String[][] sumZeroAllArr(int[] intArr) {
        Map<Integer,Integer> sumMap = new HashMap();
        Map<Integer,Integer> repSum = new HashMap();
        int sum=0;
        int startIndex=-1;
        int endIndex = -1;
        String[][] res;
        for(int i=0;i<intArr.length;i++){
            sum+=intArr[i];
            if(sumMap.containsKey(sum)){
                repSum.put(sum,i);
            }else{
                sumMap.put(sum,i);
            }
        }

        int j=0;
        if(!repSum.isEmpty()){
            Set<Integer> keys = repSum.keySet();
            res  = new String[repSum.size()][];
            for(Integer a:keys){
                endIndex = repSum.get(a);
                startIndex = sumMap.get(a)+1;
                res[j] = new String[endIndex-startIndex+1];
                int k=0;
                for(int i=startIndex;i<=endIndex;i++,k++){
                    res[j][k] = String.valueOf(intArr[i]);
                }
                j++;
            }
        }else{
            res = new String[][]{{"0"}};
        }

        return res;
    }
}
