package com.hemalatha.IK.Graphs;


import java.util.Scanner;
import java.util.StringTokenizer;

public class BloomFilterTest {


    public static  int filterSize;
    public static int hashCount;
    public static  int[] bloomFilter;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        filterSize = Integer.parseInt(in.nextLine().trim());
        hashCount = Integer.parseInt(in.nextLine().trim());
        bloomFilter = new int[filterSize];
        StringTokenizer st = new StringTokenizer(in.nextLine());
        while (st.hasMoreTokens()){
            addWord(st.nextToken().trim());
        }
        st = new StringTokenizer(in.nextLine());
        while (st.hasMoreTokens()){
            isWordInSet(st.nextToken().trim());
        }

    }

    public  static void  addWord(String word){
        int[] hashes = getHash(word);
        for(Integer i:hashes) {
            bloomFilter[i] = 1;
        }
    }

    public static  void isWordInSet(String word){
        int[] hashes = getHash(word);
        for(Integer i:hashes) {
            if(bloomFilter[i] != 1){
                System.out.println("Not present");
                return;
            }
        }
        System.out.println("Probably");
    }

    public static  int[] getHash(String wordInp){
        String word = new String(wordInp);
        int hashCnt = hashCount%wordInp.length();
         int [] result = new int[hashCnt];
        for(int i=0;i<hashCnt;i++) {
            int hash = Math.abs(word.hashCode());
            result[i] = (hash % filterSize);
            word = updateString(word,i);
        }
        return result;
    }

    public static  String updateString(String word,int i){

        return  word+"-";
    }
}
