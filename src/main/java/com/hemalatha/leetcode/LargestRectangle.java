package com.hemalatha.leetcode;

import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(largestRectangleArea(new int[]{2,4}));
        System.out.println(largestRectangleArea(new int[]{8,4}));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int area = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            if(!stack.isEmpty() && heights[stack.peek()] == heights[i]){
                stack.pop();
                stack.push(i);
            }
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i-stack.peek()-1;
                area = Math.max(area, height*width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? heights.length: heights.length - stack.peek()-1;
            area = Math.max(area,height*width);
        }
        return area;
    }
}
