package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class medianInSequence {


    public static void main(String[] args) {
        System.out.println("Hello test");
        System.out.println(findMedianInStream(List.of(1,0,3,5,2,0,1)));
    }

    public static List<Double> findMedianInStream(List<Integer> sequence){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Double> result = new ArrayList<>();
        for(int a:sequence){
            if(maxHeap.isEmpty()){
                maxHeap.add(a);
            } else if(maxHeap.peek() >= a){
                maxHeap.add(a);
            } else {
                minHeap.add(a);
            }

            if(maxHeap.size() > minHeap.size()+1){
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size() ){
                maxHeap.add(minHeap.poll());
            }

            if(maxHeap.size() == minHeap.size()){
                double t = (maxHeap.peek()+minHeap.peek()) *0.5;
                result.add(t);
            } else {
                result.add(maxHeap.peek().doubleValue());
            }
        }
        return result;
    }
}
