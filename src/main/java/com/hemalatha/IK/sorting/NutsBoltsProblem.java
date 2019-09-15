package com.hemalatha.IK.sorting;

import java.util.Scanner;
import java.util.StringTokenizer;


public class NutsBoltsProblem {

        public static void main(String args[] ) throws Exception {
            Scanner in = new Scanner(System.in);
            int size = Integer.parseInt(in.nextLine().trim());
            int[] nuts = new int[size];
            int [] bolts = new int[size];
            StringTokenizer st = new StringTokenizer(in.nextLine().trim());
            int i=0;
            while(st.hasMoreTokens()){
                nuts[i++] = Integer.parseInt(st.nextToken().trim());
            }
            st = new StringTokenizer(in.nextLine().trim());
            i=0;
            while(st.hasMoreTokens()){
                bolts[i++] = Integer.parseInt(st.nextToken().trim());
            }
            matchNutsBolts(nuts,bolts,0,size-1);
            for(int j=0;j<size;j++){
                System.out.print(nuts[j]+" "+bolts[j]);
                System.out.println();
            }
        }

        public static void matchNutsBolts(int[] nuts,int[] bolts,int low,int high){
            if(low>=high){
                return;
            }
            int pivot = partition(nuts,low,high,bolts[low]);
            partition(bolts,low,high,nuts[pivot]);
            matchNutsBolts(nuts,bolts,low,pivot-1);
            matchNutsBolts(nuts,bolts,pivot+1,high);
        }

        public static int partition(int[] arr,int low,int high,int pivot){
            int left = low;
            int right = high;

            while(left<=right){
                while(left<=right && arr[left]<=pivot){
                    left++;
                }

                while(right>=left && arr[right]>pivot){
                    right--;
                }

                if(left<=right){
                    swap(arr,left,right);
                    left++;
                    right--;
                }
            }

            swap(arr,low,right);
            return right;
        }

        public static void swap(int[] arr,int l,int r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

}
