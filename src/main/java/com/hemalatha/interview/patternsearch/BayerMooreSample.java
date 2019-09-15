package com.hemalatha.interview.patternsearch;

public class BayerMooreSample {
	
	private static char[] pattern=new char[]{'N','E','E','D','L','E'};
	private static int[] right =new int[26];
	
	static{
		for(int i=0;i<26;i++)
			right[i]=-1;
		for(int i=0;i<pattern.length;i++)
			right[pattern[i]-65]=i;
	}
	
	public static void main(String[] args){
		/*for(int i=0;i<26;i++)
			System.out.print(Character.valueOf((char)(65+i))+" :"+right[i]+" ");
		*/
		int skip=0;
		char text[]=new char[]{'F','I','N','E','E','D','L','N','E','E','D','L','E','N','E','E','D','L','E'};
		int N=text.length;
		int M=pattern.length;
		for(int i=0;i<=N-M;i+=skip){
			skip=0;
			for(int j=M-1;j>=0;j--){
			//	System.out.println("Matching "+text[i+j]+" and "+pattern[j]+" i :"+i +" j:"+j);
				if(text[i+j]!=pattern[j]){
				//	System.out.println("mismatch: Right ["+text[(i+j)]+"] :"+right[text[i+j]-65]);
					skip=Math.max(1, j-right[text[i+j]-65]);
					break;
				}
			}
		//	System.out.println("Skip :"+skip);
			if(skip==0){
				System.out.println("Found match at :"+i);
				break;
			}
		}
		
	}
	
	

}
