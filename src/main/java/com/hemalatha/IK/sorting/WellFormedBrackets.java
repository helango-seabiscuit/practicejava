package com.hemalatha.IK.sorting;

/**
 * Created by helangovan on 2/5/17.
 */

//Task is to write a function Brackets(int n) that print all combinations of well-formed brackets from 1..n 'n' is number of pairs
//Brackets(3) = (),(()) ()(),((())) (()()) (())() ()(()) ()()()
public class WellFormedBrackets {

    public static void main(String[] args) {
       WellFormedBrackets();
    }

    static void WellFormedBrackets() {
        int n=3;
      for (int i=1;i<=n;i++){
          wellFormedBrackets(i);
      }

    }

    static  void wellFormedBrackets(int n){
        if(n<=0){
            return;
        }else if(n==1){
            System.out.print("()");
        }else{
            System.out.print("(");
            wellFormedBrackets(n-1);
            System.out.print(")");
            System.out.println();
        }

    }
}
