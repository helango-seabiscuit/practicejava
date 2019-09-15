package com.hemalatha.leetcode;

public class NQueens {

	public static void main(String[] args) {
	    NQueens nQueens = new NQueens();
		System.out.println(nQueens.totalNQueens(8));
	}

	public int totalNQueens(int n) {
		Position[] p = new Position[n+1];
		int[] res = new int[1];
		totalQueens(p, 0, n,res);
		return res[0];
	}

	public void totalQueens(Position[] positions, int row, int n, int[] res){
		if(n == row){
			res[0] =  res[0]+1;
		}


		for(int col=0;col<n;col++){

			boolean found = true;
			for(int j = 0; j<row;j++){
				if(positions[j].col == col || (positions[j].row+positions[j].col == row+col) || (positions[j].col - positions[j].row == col-row)){
					found = false;
					break;
				}
			}

			if(found){
				positions[row] = new Position(row,col) ;
				totalQueens(positions, row+1,n,res);
			}
		}
		return;
	}
}

class Position {

	public int row;
	public int col;

	public Position(int row, int col){
		this.row = row;
		this.col = col;
	}

}
