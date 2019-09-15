package com.hemalatha.IK.arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by helangovan on 2/23/17.
 */
public class MissingNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int asize = Integer.parseInt(in.nextLine().trim());
        int a[] = new int [asize];
        StringTokenizer st = new StringTokenizer(in.nextLine().trim());
        int i=0;
        while(st.hasMoreTokens()){
            a[i++] = Integer.parseInt(st.nextToken().trim());
        }

        int bsize = Integer.parseInt(in.nextLine().trim());
        int b[] = new int [bsize];
        st = new StringTokenizer(in.nextLine().trim());
        i=0;
        while(st.hasMoreTokens()){
            b[i++] = Integer.parseInt(st.nextToken().trim());
        }
        missNumbers(a,b);
    }
    public static void missNumbers(int a1[],int a2[]){
        Arrays.sort(a1);
        Arrays.sort(a2);
        int j=0;
        int prev=-1;
        int i=0;
        for(;i<a2.length && j<a1.length;i++){
            if(a2[i]==a1[j]){
                j++;
//                prev = a2[i];
            }else if(a2[i]!=a1[j] && prev!=a2[i]){
                System.out.print(a2[i]+" ");
                prev = a2[i];
            }
        }
        if(i<a2.length){
            System.out.print(a2[i]);
        }
    }
}
//2437 2438 2442 2444 2447 2451 2457 2458 2466 2473 2479 2483 2488 2489 2510 2515 2517 2518