package com.hemalatha.IK.strings;

import java.util.Scanner;

/**
 * Created by helangovan on 3/5/17.
 */
public class KMPTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine().trim();
        String pattern = in.nextLine().trim();
        KMP(text,pattern);
    }

    static void KMP(String strText, String strPattern) {
        char[] text = strText.toCharArray();
        char[] pattern = strPattern.toCharArray();
        int[] prefixTable = prefixTable(pattern);
        int i=0;
        int j=0;
        while(i<text.length){
            if(text[i]== pattern[j]){
                if(j==pattern.length-1){
                    System.out.println("pattern matches at position "+(i-j));
                    j=prefixTable[j-1];
                }
                i++;
                j++;
            }else if(j>0){
                j=prefixTable[j-1];
            }else{
                i++;
            }
        }
        return;
    }

    public static int[] prefixTable(char[] pattern){
        int [] pTable = new int[pattern.length];
        int len = pattern.length;
        int i=1;
        int j=0;
        while(i<len){
            if(pattern[i]==pattern[j]){
                pTable[i] = j+1;
                j++;
                i++;
            }else if(j>0){
                j=pTable[j-1];
            }else{
                pTable[i]=0;
                i++;
            }
        }
        return pTable;
    }


}
