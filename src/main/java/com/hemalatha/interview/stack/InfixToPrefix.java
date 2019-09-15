package com.hemalatha.interview.stack;

import java.util.Stack;

public class InfixToPrefix {
	
	public static void main(String args[]){
		String inputExpr="a/b*c-d";
		String reversed=reverse(inputExpr);
		System.out.println(convertPrefix(reversed));
		
	}
	
	public static String reverse(String str){
		StringBuilder sb=new StringBuilder();
		
		if(str==null || str.isEmpty())
			throw new IllegalArgumentException("String Empty");
		int i=str.length()-1;
		while(i>=0){
			sb.append(str.charAt(i--));
		}
		
		return sb.toString();
	}
	
	public static String convertPrefix(String str){
		Stack<Character> holder=new Stack<Character>();
		StringBuilder sb=new StringBuilder();
		int i=0;
		int len=str.length();
		while(i<len){
			Character ch=str.charAt(i);
			if(ch==' '|| ch=='\t')
				continue;
			if(Character.isDigit(ch) || Character.isLetter(ch)){
				sb.append(ch);		
			}
			else if(ch=='^'|| ch=='%' || ch=='*'|| ch=='/' || ch=='+' || ch=='-'){
				char c;
				if(!holder.isEmpty()){
				int pr=priority(ch);				
				
				while(!holder.isEmpty() && priority(holder.peek()) >pr){
					sb.append(holder.pop());									
				}				
				holder.push(ch);
				}
				else
				holder.push(ch);
				
			}
			else if(ch==')')
				holder.push(ch);
			else if(ch=='('){
				char c=holder.pop();
				while(c!=')'){
					sb.append(c);
					c=holder.pop();
				}
			}
			i++;
		}
		while(!holder.isEmpty()){
			sb.append(holder.pop());
		}
		
	  return sb.reverse().toString();	
	}
	
	public static int priority(char c){
		if(c=='^' || c=='%')
			return 3;
		else if(c=='*' || c=='/')
			return 2;
		else if(c=='+'|| c=='-')
			return 1;
		return -1;
	}

}
