package com.hemalatha.IK.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by helangovan on 3/8/17.
 */
public class PalindromicDecompositionTest {

    private static List<String> strList;
    public static void main(String[] args) {
       // palindromeCreator("abba".toCharArray(),0);
        //abracadabra
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().trim();
        strList = new ArrayList<>();
        char[] decomposition = new char[input.toCharArray().length*2];
        palindromeCreator(input.toCharArray(),0,decomposition,0);
        String [] str = new String[strList.size()];
        int i=0;
        for(String t:strList){
            str[i++]=t;
            System.out.println(t);
        }

    }

    public static  void palindromeCreator(char[] str,int i, char[] decomposition, int write){
        if(i==str.length){
//            for(int j=0;j<write;j++){
//                System.out.print(decomposition[j]);
//            }
//            System.out.println();
            strList.add(new String(decomposition,0,write));
        }
        for(int k=i;k<str.length;k++) {
            if (isPalindrome(str,i, k)) {
                int w =write;
                for(int j=i;j<=k;j++){
                    decomposition[w++]=str[j];
                }
                decomposition[w++]='|';
                palindromeCreator(str, k + 1,decomposition,w);
                }
            }
        }

    public static boolean isPalindrome(char [] str,int k,int i){
        for(int j=k;j<=i&&i>=j;j++,i--){
            if(str[j]!=str[i]){
                return false;
            }
        }
        return true;
    }
}
