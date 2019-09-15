package com.hemalatha.leetcode;

public class PrisonCells {
	public static void main(String[] args) {
		PrisonCells cells = new PrisonCells();
		cells.prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1},1);
	}

	public int[] prisonAfterNDays(int[] cells, int N) {

		int num = 0;
		for(int i=0;i<=7;i++){
			num += cells[i]*Math.pow(2,7-i);
		}
		System.out.println(num);
		int n1 = num;
		int n2 = num <<2;
		//System.out.println(n2);
		int k=1;
		int c=7;
		int res;
		String t =null;
		while (k<=N){
			t = "0";
			while (c>=2){
              if(((n1 & (1<<c) ) & (n2 & (1<<c-1)))>0){
              	t+="1";
			  }else{
              	t+='0';
			  }
			  n1 = n1 <<1;
			  n2 = n2 <<2;
			  c--;
			}
			k++;
		}
		System.out.println(t);
		return null;

	}
}
