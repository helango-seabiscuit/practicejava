package com.hemalatha.interview.arrays.sort;

public class LSDRadixSort {

	/**
	 * @param args
	 */
	private static int R = 256;
	
	public static void main(String[] args) {
		String s[]= {"hemaa","hemua","meena","dines","nares","saruu"};
		LSDRadixStringSort(s,5 );

	}
	
	public static void LSDRadixStringSort(String[] a,int W){
		int count[] = new int[R];
		String [] aux = new String[a.length];
		
		for(int j = W-1;j>=0;j--){
		for(int i = 0;i<R;i++)
			count[i] = 0;
		
		for(int i = 0;i<a.length;i++)
			count[a[i].charAt(j)]=count[a[i].charAt(j)]+1;
		
		for(int i = 1;i<R;i++)
			count[i] += count[i-1];
		
		for(int i = a.length-1;i >=0;i--){
			aux[count[a[i].charAt(j)]-1] = a[i];
			count[a[i].charAt(j)] = count[a[i].charAt(j)]-1;			
		}
		
		for(int i = 0;i<aux.length;i++)
			a[i] = aux[i];
	}
		
		for(String s:aux)
			System.out.printf("%s,",s);
	}

}
