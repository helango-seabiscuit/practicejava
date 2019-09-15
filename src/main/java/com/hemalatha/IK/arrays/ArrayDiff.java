package com.hemalatha.IK.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by helangovan on 3/4/17.
 */
public class ArrayDiff {

    public static void main(String[] args) {
        //int arr[] = new int[]{3,1,4,1,5};
        int arr[] = new int[]{3,1,1,3};
        System.out.println(countDiffPair(arr,2));
        char[][] pic = new char[][]{{'W','B','B'},{'B','W','W'},{'W','W','W'}};
        System.out.println(countLonelyBlack(pic));

    }

    public static int countDiffPair(int[] arr,int diff){
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i]-diff)!=null){
                set.add(arr[i]-diff);
            }

            if(map.get(arr[i]+diff)!=null){
                set.add(arr[i]);
            }
            map.put(arr[i],i);
        }
        return set.size();
    }

    public static int countLonelyBlack(char[][] pic){
        int row[] = new int[pic.length];
        int col[] = new int[pic[0].length];
        for(int i=0;i<pic.length;i++){
            for(int j=0;j<pic[0].length;j++){
                if(pic[i][j]=='B'){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int count=0;
        for(int i=0;i<pic.length;i++) {
            for (int j = 0; j < pic[0].length; j++) {
                if(row[i]==1 && col[j]==1 && pic[i][j]=='B'){
                    count++;
                }
            }
        }
        return count;

    }
}
