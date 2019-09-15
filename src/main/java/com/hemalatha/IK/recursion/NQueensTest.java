package com.hemalatha.IK.recursion;


public class NQueensTest {

    public static void main(String[] args) {
        for(int i=1;i<=10;i++) {
            System.out.println("Start N Queen -"+i);
            int[][] board = new int[i][i];
            nQueensRecur2(board, 0);
            System.out.println("End N Queen -"+i);
        }

    }

    //To print one solution
    public static boolean nQueensRecur(int[][] board,int col){
        if(col>=board[0].length){
            System.out.println();
            for(int k=0;k<board.length;k++) {
                for(int l=0;l<board[0].length;l++){
                    System.out.print(board[k][l]);
                }
                System.out.println();
            }
            return true;
        }
        for(int i=0;i<board.length;i++){
            if(queenPlaced(board,i,col)){
                board[i][col]=1;
                if(nQueensRecur(board,col+1)){
                    return true;
                }
                board[i][col]=0;
            }

        }
        return false;
    }

    public static void nQueensRecur2(int[][] board,int col){
        if(col>=board[0].length){
            for(int k=0;k<board.length;k++) {
                for(int l=0;l<board[0].length;l++){
                    System.out.print(board[k][l]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int i=0;i<board.length;i++){
            if(queenPlaced(board,i,col)){
                board[i][col]=1;
                nQueensRecur2(board,col+1);
                }
                board[i][col]=0;
            }

        }



    public static boolean queenPlaced(int [][] board,int row,int col){
        for(int i=0;i<col;i++){
            if(board[row][i]==1){
                return false;
            }
        }

        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
             if(board[i][j]==1){
                 return false;
             }
        }

        for(int i=row,j=col;i<board.length && j>=0;i++,j--){
            if(board[i][j]==1){
                return false;
            }
        }
        return  true;
    }
}
