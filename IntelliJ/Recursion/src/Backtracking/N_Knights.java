package Backtracking;

public class N_Knights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        knight(board,0,0,4);
    }

    static void knight(boolean[][] board,int row,int col,int knights){
        if (knights==0){
            display(board);
            System.out.println();
            return;
        }

        //this for handling out of bound cols, this below condition is specifically for the end of the board
        if (row==board.length - 1 && col == board.length){
            //in this case just skip it
            return;
        }
        if (col == board.length){
            //if col == board.length then this line is finished and now check for the below lines
            knight(board,row+1,0,knights);
            return;
        }
        if (isSafe(board,row,col)){
            //then just place the knight
            board[row][col] = true;
            //if it is true then check for the next col
            knight(board,row,col+1,knights-1);
            board[row][col] = false;
            //now you backtrack, because you have previously placed a knight

        }
        knight(board,row,col+1,knights);
        //in any case just move ahead, because you weren't able to place the knight
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board,row-2,col-1)){
            if (board[row -2][col-1]){
                //means if it is true then knight was already at that position
                return false;
            }
        }
        if (isValid(board,row-2,col+1)){
            if (board[row-2][col+1]){
                //means if it is true then knight was already at that position
                return false;
            }
        }
        if (isValid(board,row-1,col+2)){
            if (board[row-1][col+2]){
                //means if it is true then knight was already at that position
                return false;
            }
        }
        if (isValid(board,row-1,col-2)){
            if (board[row-1][col-2]){
                //means if it is true then knight was already at that position
                return false;
            }
        }

        //in the end if none of these conditions returns false, then return true
        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col){
        //this functions is for checking whether the arguments you have passed are out of bounds or not
        //following => do not repeat yourself principle we created this function
        if (row>=0 && row < board.length  && col>=0 &&col< board.length){
            //beacuse we are considering nXn board so we don't do col < board[0].length as that will be same as board.length
            return true;
        }
        return false;
    }

    public static void display(boolean[][] board) {
        for (boolean[] row:board) {
            for (boolean element:row){
                if (element){
                    System.out.print("K");
                }
                else{
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
}
