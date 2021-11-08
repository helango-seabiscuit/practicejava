package com.hemalatha.company.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=720422605157879&ppid=454615229006519&practice_plan=0
public class CountingTriangle {

    static class Sides{
        int a;
        int b;
        int c;
        Sides(int a,int b,int c){
            int arr[] = new int[3];
            arr[0] = a;
            arr[1]=b;
            arr[2] = c;
            Arrays.sort(arr);
            this.a = arr[0];
            this.b = arr[1];
            this.c = arr[2];
        }

        public boolean equals(Object o){
            if(o== this){
                return true;
            }
            Sides s = (Sides)o;
            return this.a == s.a && this.b == s.b && this.c == s.c;
        }

        public int hashCode(){
            return Integer.hashCode(a)+Integer.hashCode(b)+Integer.hashCode(c);
        }
    }


    // Add any helper functions you may need here


    static int countDistinctTriangles(ArrayList<Sides> arr) {
        // Write your code here
        Set<Sides> set = new HashSet<>();
        for(Sides s: arr){
            if(!set.contains(s)){
                set.add(s);
            }
        }
        return set.size();
    }


    public static void main(String[] args) {
        ArrayList<Sides> arr_1 = new ArrayList<>();
        arr_1.add(new Sides(7, 6, 5));
        arr_1.add(new Sides(5, 7, 6));
        arr_1.add(new Sides(8, 2, 9));
        arr_1.add(new Sides(2, 3, 4));
        arr_1.add(new Sides(2, 4, 3));
        int expected_1 = 3;
        int output_1 = countDistinctTriangles(arr_1);
        System.out.println(output_1);

        ArrayList<Sides> arr_2 = new ArrayList<>();
        arr_2.add(new Sides(3, 4, 5));
        arr_2.add(new Sides(8, 8, 9));
        arr_2.add(new Sides(7, 7, 7));
        int expected_2 = 3;
        int output_2 = countDistinctTriangles(arr_2);
        System.out.println(output_2);

        //[[5, 8, 9], [5, 9, 8], [9, 5, 8], [9, 8, 5], [8, 9, 5], [8, 5, 9]]
        ArrayList<Sides> arr_3 = new ArrayList<>();
        arr_3.add(new Sides(5, 8, 9));
        arr_3.add(new Sides(5, 9, 8));
        arr_3.add(new Sides(9,5,8));
        arr_3.add(new Sides(9,8,5));
        arr_3.add(new Sides(8,9,5));
        arr_3.add(new Sides(8,5,9));
        int expected_3 = 1;
        int output_3 = countDistinctTriangles(arr_3);
        System.out.println(output_3);
    }


}
