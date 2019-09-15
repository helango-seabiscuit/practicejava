package com.hemalatha.IK.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by helangovan on 2/21/17.
 */
public class MergeIntervals {

    static class Pair{
        int start;
        int end;
        Pair(int start,int end){
            this.start = start;
            this.end= end;
        }

        public String toString(){
            return "{"+this.start+","+this.end+"}";
        }
    }
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine().trim());
        Pair [] input = new Pair[size];
        int i=0;
        StringTokenizer st;
        while(i<size){
             st = new StringTokenizer(in.nextLine().trim());
            input[i++] = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Pair[] res = mergeIntervals(input);
        for(Pair p: res){
            System.out.println(p);
        }
    }

    public static Pair[] mergeIntervals(Pair[] intSets){
        int len = intSets.length;
        //sort the pair sets
        Comparator<Pair> comp =(Pair p1, Pair p2)-> { return p1.start-p2.start ;};
        Arrays.sort(intSets,comp);
        Stack<Pair> store = new Stack<>();
        for(int i=0;i<len;i++){
            if(store.isEmpty() || store.peek().end < intSets[i].start){
                store.push(intSets[i]);
                continue;
            }
            if(intSets[i].end> store.peek().end){
                store.peek().end = intSets[i].end;
            }

        }
        Pair res[] = new Pair[store.size()];
        int j=store.size()-1;
        while(!store.isEmpty()){
            res[j--] = store.pop();
        }
        return res;
    }
}
