package com.hemalatha.IK.sorting;


public class SubsetFinder {


    //sorted array
    public static  boolean isSubset(int[] arr,int[] arr2){
        int len1 = arr.length;
        int len2 = arr2.length;
        int fpt = 0;
        int spt = 0;

        while (fpt <len1  && spt < len2 ){
            if(arr[fpt] == arr2[spt]){
                fpt++;
                spt++;
            }else if(arr[fpt] > arr2[spt]) {
                break;
            }else{
                fpt++;
            }
        }
        if(spt==len2){
            return  true;
        }
        return  false;
    }

    public static void main(String[] args) {
        System.out.println(isSubset(new int[]{3,4,5,6,7,8},new int[]{6,7}));
        System.out.println(isSubset(new int[]{3,4,5,6},new int[]{6,7}));
        System.out.println(isSubset(new int[]{1,2,3,4,6,7,8,9,11},new int[]{1,2,3}));
    }
}
