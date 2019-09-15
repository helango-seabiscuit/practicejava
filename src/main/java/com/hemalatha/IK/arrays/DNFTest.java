package com.hemalatha.IK.arrays;

public class DNFTest {

    public static void main(String[] args) {
        int arr[] = new int[]{0,1,2,1,1,2,0,2};
        arr = dnf(arr);
        arr= new int[]{2,2,0,0,1,2,0,1};
        arr = dnf(arr);
        for(int a:arr){
            System.out.print(a+",");
        }
    }

    public static int[] dnf(int[] arr){
        int i=0,j=0,k=arr.length-1;
        while(j<=k){
            if(arr[j]==0){
                int t = arr[j];
                arr[j]=arr[i];
                arr[i]=t;
                i++;
                j++;
            }
            if(arr[j]==1){
                j++;
            }
            if(arr[j]==2){
                arr[j]=arr[k];
                arr[k]=2;
                k--;
            }
        }
        return arr;
    }
}
