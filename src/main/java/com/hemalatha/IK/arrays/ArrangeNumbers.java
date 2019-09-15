package com.hemalatha.IK.arrays;

/**
 * Created by helangovan on 3/23/17.
 */
public class ArrangeNumbers {

    public static void main(String[] args) {
        System.out.println(arrange("62832"));
    }

    public static   String arrange(String num){
        char[] input = num.toCharArray();
        int[] temp = new int[10];
        for(Character c:input){
            if(c >= 48 && c<=57){
                temp[c-48]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=9;i>=0;i--){
            int count = temp[i];
            while(count >0){
                sb.append(i);
                count--;
            }
        }
        return sb.toString();
    }
}
