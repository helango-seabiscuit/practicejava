package com.hemalatha.IK.arrays;

import java.util.StringTokenizer;

/**
 * Created by helangovan on 3/11/17.
 */
public class MinTImeDifference {

    public static void main(String[] args) {
        System.out.println(convertToMinutes("23:59"));
        System.out.println('0'-48);
    }


    public static int convertToMinutes(String s){
        StringTokenizer st = new StringTokenizer(s,":");
        int hour = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());
        return hour*60+minutes;
    }
}
