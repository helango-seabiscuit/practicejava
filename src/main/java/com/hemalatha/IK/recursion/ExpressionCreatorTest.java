package com.hemalatha.IK.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by helangovan on 3/4/17.
 */
public class ExpressionCreatorTest {

    private static  char[] symbols = new char[]{'-','+','/','*'};
    public static void main(String[] args) {
//        System.out.println(evaluateExpression("22+2*2"));
//        System.out.println(evaluateExpression("22*2*2"));
//        System.out.println(evaluateExpression("222+2*2"));
//        System.out.println(evaluateExpression("2+22+2*2"));
//        System.out.println(Arrays.deepToString(expressionCreator("222",24)));
        System.out.println("2+22".substring(2,2));
        System.out.println("222".substring(1));
        System.out.println(Arrays.deepToString(expressionCreator("222",8)));
    }

    static Object[] expressionCreator(String strDigits, int iK) {
        List<String> result = new ArrayList<>();
        expressionCreator(strDigits,iK,0,strDigits,result);
        return result.toArray();

    }
    static void expressionCreator(String strDigits, int iK, int i, String result,List<String> res) {
        if(evaluateExpression(result)==iK){
            res.add(result);
        }
        if(i==strDigits.length()-1){
            return;
        }
        int k=0;
        for(int j=i;j<strDigits.length()-1;j++){
            String res1 = result.substring(j,j+1)+"+"+result.substring(j+1);
            k=j+1;
            if(k<strDigits.length()-1) {
                k++;
            }
            expressionCreator(strDigits, iK, k , res1,res);
            String res2 = result.substring(j,j+1)+"*"+result.substring(j+1);
            expressionCreator(strDigits,iK,k,res2,res);
        }


    }



    public static int evaluateExpression(String expr){
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

        char[] input = expr.toCharArray();
        for(int i=0;i<input.length;i++){
            if(input[i]>='0' && input[i]<='9'){
                String numString ="";
                while (i<input.length && Character.isDigit(input[i])){
                 numString+=input[i++];
                }
                operands.push(Integer.valueOf(numString));
                i--;
            }else {
                while (!operators.isEmpty() && getPrecedence(operators.peek()) >= getPrecedence(input[i])) {
                    Character opr = operators.pop();
                    int op2 = operands.pop();
                    int op3 = operands.pop();
                    int result = evaluate(op3, op2, opr);
                    operands.push(result);
                }
                operators.push(input[i]);
            }

        }

        while (!operators.isEmpty()){
            Character opr = operators.pop();
            int op2 = operands.pop();
            int op3 = operands.pop();
            int result = evaluate(op3,op2,opr);
            operands.push(result);
        }
        return operands.pop();
    }

    public static int getPrecedence(char operator){
        for(int i=0;i<symbols.length;i++){
            if(symbols[i]==operator){
                return i;
            }
        }
        return -1;
    }

    public static int evaluate(int o1,int o2,char operator){
         switch (operator){
             case '+': return o1+o2;
             case '-': return o1-o2;
             case '*': return o1*o2;
             case '/': return o1/o2;
         }
         return 0;
    }
}



