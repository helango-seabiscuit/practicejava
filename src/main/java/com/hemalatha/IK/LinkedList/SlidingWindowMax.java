package com.hemalatha.IK.LinkedList;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class SlidingWindowMax {



    public static int[] maxSlidingWindow(int[]a,int k){
//        ArrayDeque<Integer> deque = new ArrayDeque<>();
//        int b[] = new int[arr.length-k+1];
//        int j=0;
//        for(int i=0;i<arr.length;i++){
//            if(!deque.isEmpty() && j>i-k+1){
//                deque.poll();
//            }
//            while (!deque.isEmpty() && arr[deque.peek()]<arr[i]){
//                deque.poll();
//            }
//            deque.offer(i);
//            if(j==i-k+1) {
//                b[j++] = arr[deque.peek()];
//            }
//        }
//        return b;

        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int size = Integer.parseInt(in.nextLine().trim());
//        int [] arr = new int[size];
//        for(int i=0;i<size;i++){
//            arr[i] = Integer.parseInt(in.nextLine().trim());
//        }
//        int wsize = Integer.parseInt(in.nextLine().trim());

        //System.out.println(Arrays.toString(maxSlidingWindow(arr,wsize)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,2,-2,5},3)));
    }
}
