package com.hemalatha.IK.arrays;

import java.util.Scanner;

/**
 * Created by helangovan on 2/20/17.
 */
public class SearchMatrix {

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        int m = Integer.parseInt(in.nextLine().trim());
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(in.nextLine().trim());
            }
        }
        int elem = Integer.parseInt(in.nextLine().trim());
        searchElement(arr,n-1,m-1,elem);
    }

    public static void searchElement(int[][] arr,int n,int m,int elem ){
        int i=0;
        int j = m;
        while(i<=n && j>=0){
            if(arr[i][j]==elem){
                System.out.println(i+" "+j);
                break;
            }else if(arr[i][j]>elem){
                j--;
            }else {
                i++;
            }
        }
    }
}
