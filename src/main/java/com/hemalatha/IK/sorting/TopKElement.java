package com.hemalatha.IK.sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by helangovan on 1/29/17.
 */
public class TopKElement {

   static class IntDesc implements Comparator<Integer>{

       public int compare(Integer a, Integer b){
           return b.compareTo(a);
       }
   }

    static int[] topK(int[] iStream, int iK) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new IntDesc());

        for(int i:iStream){
            if(queue.size()==iK){
                if(i>queue.peek()){
                    queue.poll();
                    queue.offer(i);
                }
            }else{
                queue.offer(i);
            }
        }

        int res[] = new int[iK];
        for(int i=0;i<iK;i++){
            res[i]= queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{5,4,8,12,3,2,1,18};
        for(Integer i:topK(arr,4)){
            System.out.println(i);
        }
    }
}
