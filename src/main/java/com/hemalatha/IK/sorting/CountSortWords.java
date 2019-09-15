package com.hemalatha.IK.sorting;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by helangovan on 2/13/17.
 */
public class CountSortWords {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine().trim());
        int [] arr = new int[size];
        String [] words = new String[size];
        for(int i=0;i<size;i++){
            StringTokenizer st = new StringTokenizer(in.nextLine().trim());
            arr[i] = Integer.parseInt(st.nextToken().trim());
            words[i] = st.nextToken().trim();
        }
        //fullCountSort(arr,words);
        fullCountSort2(arr,words);
    }

    public static void fullCountSort(int [] arr,String[] words){
        int temp2[] = new int[100];
        int temp[] = new int[100];
        String subLists[] = new String [words.length];

        for(Integer a:arr){
            temp[a]++;
        }

          for(int i=1;i<100;i++){
            temp2[i]=temp2[i-1]+temp[i-1];
        }
        int index=0;
        int mid = arr.length/2;
        for(int i=0;i<words.length;i++){
            index = temp2[arr[i]];
            if(i<mid){
                subLists[index]="-";
            }else{
                subLists[index]=words[i];
            }
            temp2[arr[i]]++;
        }


        for(String s:subLists){
            System.out.print(s+" ");
        }

    }

    public static void fullCountSort2(int [] arr,String[] words){
        int temp[] = new int[100];
        int temp2[] = new int[100];
        String subLists[] = new String [words.length];

        for(Integer a:arr){
            temp[a+1] = temp[a]+temp[a+1]+1;;
        }


        int index=0;
        int mid = arr.length/2;
        for(int i=0;i<words.length;i++){
            index = temp[arr[i]];
            if(i<mid){
                subLists[index]="-";
            }else{
                subLists[index]=words[i];
            }
            temp[arr[i]]++;
        }


        for(String s:subLists){
            System.out.print(s+" ");
        }
    }
}
