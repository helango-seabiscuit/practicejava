package com.hemalatha.IK.recursion;

/**
 * Created by helangovan on 3/1/17.
 */
public class PermutationTest {

    public static void main(String[] args) {
        System.out.println(permutationSet(new char[]{'a','b','c','d'},0));
    }


    public static int  permutationSet(char[] arr,int i){
        if(i==arr.length){
            System.out.print("{");
            System.out.print(arr);
            System.out.print("}");
            System.out.println();
            return 1;
        }
        int count =0;
        for (int j=i;j<arr.length;j++){
            swap(arr,i,j);
            count+=permutationSet(arr,i+1);
            swap(arr,i,j);
        }
        return count;
    }

    public static void swap(char[]arr,int i,int j){
        char temp = arr[i];
        arr[i]= arr[j];
        arr[j]=temp;
    }
}
