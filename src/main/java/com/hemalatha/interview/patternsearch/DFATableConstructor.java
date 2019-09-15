package com.hemalatha.interview.patternsearch;

public class DFATableConstructor {
	
	private static  int[][] dfa;
	
	public DFATableConstructor(int numStates, int numSymbols) {
		dfa = new int[numSymbols][numStates];
	}
	
	public int[][] constructDFA(String pattern){
		char []pat = pattern.toCharArray();
		int x=0;
		
	//	dfa[0][0]= dfa[1][0] = dfa[2][0] = 0;
		dfa[pat[0]-65][0]=1;
		for(int i=1;i<pat.length;i++ ){
			for(int c=0;c<3;c++){
				dfa[c][i] = dfa[c][x];
			}
			dfa[pat[i]-65][i]=i+1;
			
			x = dfa [pat[i]-65][x];
			
		}
		
		return dfa;
	}
	
	public static void main(String args[]){
		DFATableConstructor dfaTable = new DFATableConstructor(8, 3);
		System.out.println("DFA Table ");
	//	int dfa[][]=dfaTable.constructDFA("CACACBCB");
		int dfa[][]=dfaTable.constructDFA("ACACABAB");
		for(int i=0;i< dfa.length ;i++){
			for(int j=0 ; j<dfa[i].length ; j++)
				System.out.print(dfa[i][j]+"  ");
		 System.out.println();
	     }
	}
	

}
