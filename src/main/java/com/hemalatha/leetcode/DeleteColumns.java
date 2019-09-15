package com.hemalatha.leetcode;

public class DeleteColumns {
	public static void main(String[] args) {

		DeleteColumns columns = new DeleteColumns();
//		System.out.println(columns.minDeletionSize(new String[]{"ca","bb","ac"}));//1
//		System.out.println(columns.minDeletionSize(new String[]{"xc","yb","za"}));//0
//		System.out.println(columns.minDeletionSize(new String[]{"zyx","wvu","tsr"}));//3
		System.out.println(columns.validMountainArray(new int[]{0,3,2,1}));//3
	}

	public boolean validMountainArray(int[] A) {
		if(A==null || A.length<3){
			return false;
		}

		int i=1;
		for(;i< A.length && A[i-1]<=A[i];i++);

		int j=A.length-1;
		for(;j>0 && A[j-1]>A[j] ;j--);

		return (i==A.length || j==0)?false:i-1==j;

	}


	public int minDeletionSize(String[] A) {
		int res = 0;
		int num = A.length;
		int len = A[0].length();

		boolean sorted[] = new boolean[num];
		String []cur = new String[num];
		for(int i=0;i<len;i++){
			int j=0;
			for (;j<num-1;j++){
				if(!sorted[j]&& A[j].charAt(i)>A[j+1].charAt(i)){
					res++;
					break;
				}
			}
			if (j == num - 1) {
				for (j = 0; j < num - 1; ++j)
					if (A[j].charAt(i) < A[j + 1].charAt(i))
						sorted[j] = true;
			}
		}

		return res;
	}
}
