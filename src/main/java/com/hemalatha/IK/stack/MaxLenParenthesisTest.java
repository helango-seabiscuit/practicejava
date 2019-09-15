package com.hemalatha.IK.stack;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by helangovan on 1/25/17.
 */
public class MaxLenParenthesisTest {


    static  Stack<Character> parStack;
    static List<Character> closingParenthesis;
    static HashMap<Character,Character> matchers;
    static {
        parStack = new Stack<>();
        closingParenthesis = new ArrayList<>();
        closingParenthesis.add('{');
        closingParenthesis.add('[');
        closingParenthesis.add('(');
        matchers = new HashMap<>();
        matchers.put('}','{');
        matchers.put(')','(');
        matchers.put(']','[');
        BitSet bs = new BitSet(5);
    }
    static int maxLenMatchingParen(String strParenExpression) {
     char input[] = strParenExpression.toCharArray();
        int count = 0;
        for(Character c:input){
            if(closingParenthesis.contains(c)){
                parStack.push(c);
                continue;
            }
            Character res = matchers.get(c);
            if(res!=null){
                if(!parStack.isEmpty() && res.equals(parStack.pop())){
                    count+=2;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
//        System.out.println(maxLenMatchingParen("()()()"));
//        System.out.println(maxLenMatchingParen("((((("));
//        System.out.println(maxLenMatchingParen("((((())(((()"));
        System.out.println(maxLenMatchingParen(")"));
    }

}
