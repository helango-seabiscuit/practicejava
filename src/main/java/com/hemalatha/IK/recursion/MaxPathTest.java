package com.hemalatha.IK.recursion;

/**
 * Created by helangovan on 2/28/17.
 */
public class MaxPathTest {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int rsize = Integer.parseInt(in.nextLine().trim());
//        int csize = Integer.parseInt(in.nextLine().trim());
//        int arr[][] = new int[rsize][csize];
//        for(int i=0;i<rsize;i++){
//            for(int j=0;j<csize;j++){
//                arr[i][j] = Integer.parseInt(in.nextLine().trim());
//            }
//        }
        int[][] arr={{0,1,3,4},
                      {9,5,6,7},
                      {0,1,3,4},
                     };
        System.out.println(findMaxBestPath(arr));
    }

    public static int findMaxBestPath(int[][]arr){
        return findMaxPath(arr,0,0);
    }


    public static int findMaxPath(int[][]arr,int i,int j){
        if(i==arr.length-1 && j==arr[0].length-1){
            return arr[i][j];
        }

        if(i==arr.length-1){
            return arr[i][j]+findMaxPath(arr,i,j+1);
        }

        if(j==arr[0].length-1){
            return arr[i][j]+findMaxPath(arr,i+1,j);
        }

        int right = findMaxPath(arr,i,j+1);
        int down = findMaxPath(arr,i+1,j);
        int max = Math.max(right,down);
        return max+arr[i][j];
    }
}
