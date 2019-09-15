package com.hemalatha.IK.strings;

import java.util.Scanner;

/**
 * Created by helangovan on 4/2/17.
 */

//Iam very proud of this soln. Eventhough its not optimal I wrote by myself :)

//nailed - n4d,na3d,n3ed,n2led,na2ed,nai2d
    //batch - b3h,ba2h,b2ch
public class Neuronyms {

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        printNeuronyms(in.nextLine().trim());
    }

    public static void  printNeuronyms(String s){
        if(s==null || s.length()<=3){
            return;
        }
        int left = 1;
        int right = s.length()-1;
        int startCount = s.substring(left,right).length();
        for(int i = startCount;i>=2;i--){
            for(int j=left;j+i<=right;j++){
                System.out.print(s.substring(0,left)+s.substring(left,j)+i+s.substring(j+i,right)+s.substring(right,right+1)+" ");
            }
            System.out.println();
        }

    }

}
