package com.hemalatha.recursion;

public class MakeChange {

	public static void main(String[] args) {
		System.out.println(makingChange(new int[]{1,5,10,25}, 1));//1
		System.out.println(makingChange(new int[]{1,5,10,25}, 6));//2
		System.out.println(makingChange(new int[]{1,5,10,25}, 49));//7
	}

	public static int makingChange(int[] coins, int amt){
		int[] val = new int[1];
		val[0] = Integer.MAX_VALUE;
		makingChange(coins, 0, amt,0,val,0);
		return val[0];

	}

	public static void makingChange(int[] coins,int i, int amt, int currAmt, int[] val,int count){
		if(currAmt > amt){
			return;
		}

		if(i == coins.length && currAmt != amt){
			return;
		}

	//	if(currAmt == amt && (val[0]!= 0 && count < val[0])){
		if(currAmt == amt && count < val[0]){
			val[0] = count;
			return;
		}
		if(i == coins.length){
			return;
		}

		makingChange(coins, i, amt, currAmt+coins[i], val, count+1);
		makingChange(coins, i+1, amt, currAmt, val, count);
	}
}
