package com.hemalatha.interview.arrays.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by helangovan on 1/29/17.
 */
public class MergeSortTwoArrays {

    static int[] mergeFirstIntoAnother(int[] intArrShort, int[] intArrLong) {
        int numLen = intArrShort.length;
        int arrLen = intArrLong.length;
        int ptr = arrLen-1;

        int findex = numLen-1;
        int secindex = arrLen-numLen-1;

        while(findex>=0 && secindex>=0){
            if(intArrShort[findex]>intArrLong[secindex]){
                intArrLong[ptr]=intArrShort[findex];
                findex--;
                ptr--;
            }else if(intArrShort[findex]<intArrLong[secindex]){
                intArrLong[ptr]=intArrLong[secindex];
                secindex--;
                ptr--;
            }else{
                intArrLong[ptr--]=intArrLong[secindex];
                intArrLong[ptr]=intArrLong[secindex];
                secindex--;
                findex--;
                ptr--;
            }
        }

        if(findex>=0){
            while(findex>=0){
                intArrLong[ptr]=intArrShort[findex];
                findex--;
                ptr--;
            }
        }
        return intArrLong;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrShort = Integer.parseInt(in.nextLine().trim());
        int [] arrSh = new int[arrShort];
        for(int i =0;i<arrShort;i++){
            arrSh[i] = Integer.parseInt(in.nextLine().trim());
        }

        int arrLong = Integer.parseInt(in.nextLine().trim());
        int []arrLo = new int[arrLong];
        for(int i=0;i<arrLong;i++){
             arrLo[i] = Integer.parseInt(in.nextLine().trim());
        }

        System.out.println(Arrays.toString(mergeFirstIntoAnother(arrSh,arrLo)));
    }
}
