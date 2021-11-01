package com.hemalatha.leetcode;

import java.util.Arrays;

public class WeakestRow {

    public static void main(String[] args) {

    }

    public int[] kWeakestRows(int[][] mat, int k) {
        if (mat == null || mat.length == 1 ){
            return new int[0];
        }

        int[] [] wm = new int [mat.length][1];
        for(int i =0 ;i<mat.length;i++) {
            for(int j = 0;j<mat[i].length;j++){
                if(mat[i][j] == 1) {
                    wm[i][0]++;
                }
            }
        }

        Arrays.sort(wm, (a1,a2) -> {
            return Integer.compare(a1[0], a2[0]);
        });

        int [] res = new int[k];
        for(int i =0;i<k;i++){
            res[i] = wm[i][0];
        }
        return res;

    }
}
