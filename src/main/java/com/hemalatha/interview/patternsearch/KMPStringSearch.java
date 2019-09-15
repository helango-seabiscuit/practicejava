package com.hemalatha.interview.patternsearch;

public class KMPStringSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String text="CCAABBABABACACACCCABABACABABCAB";
		String pattern="ACCCABAB";
		DFATableConstructor dfaTable = new DFATableConstructor(8, 3);		
		int dfa[][]=dfaTable.constructDFA(pattern);		
		for(int i=0;i< dfa.length ;i++){
			for(int j=0 ; j<dfa[i].length ; j++)
				System.out.print(dfa[i][j]+"  ");
		 System.out.println();
	     }
		int pointer = 0;
		for(int i=0;i < text.length();i++){
			pointer = dfa[text.charAt(i)-65][pointer];			
			
			if(pointer == pattern.length()){
				System.out.println("Found Pattern at :" + (i+1-pattern.length()));
				break;
			}
			
		}
		

	}

}
