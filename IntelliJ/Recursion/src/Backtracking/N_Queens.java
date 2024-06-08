package Backtracking;

public class N_Queens {
    public static void main(String[] args) {
        //true means a queen is placed there
        int n = 70;
        boolean[][] board = new boolean[n][n];
        //it is initialized with false
        System.out.println(queens(board,0));

    }

    static int queens(boolean[][] board,int row){
        //through this method we get the no of ways by which we can place queen in the board and also their position
        //not passing the col as we are anyways starting it from 0 everytime
        if (row == board.length){
            //it means all the queens have been placed
            display(board);
            System.out.println();
            return 1;
            //you've found 1 answer
        }
        int count = 0;
        //placing the queen, hence we are also checking for every row and col
        for (int col = 0; col < board.length; col++) {
            //place the queen if it is safe
            if (isSafe(board,row,col)){
                board[row][col] = true;
                //means if the queen is placed -> true, if not then false ( The default )
                //hence this row is placed now try to see for the below rows
                count = count + queens(board,row+1);
                board[row][col] = false;
                //this is the backtracking thing, because 2 cases :
                //agar ans mil gya => Print the answer through the base condition and start looking for more ans, hence backtrack
                //ans nhi milaa => base condition fail, backtrack and search next cell or row or col where the ans can be
                //found

            }
        }

        return count;
        //this count is just the additional things which tells, how many ways we can place the queens
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        //check vertical availability of queen
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                //as we are moving vertically up the col remains same and only the row changes
                //means there is a queen over there so it is unsafe to place our our queen below this ( i,col) cell
                return false;
            }
        }

        //LEFT diagonal check
        int maxLeft = Math.min(row,col);
        for (int i = 0; i <= maxLeft; i++) {
            if (board[row-i][col-i]){
                return false;
            }
        }

        //RIGHT diagonal check
        int maxRight = Math.min(row,board.length - col -1);
        for (int i = 0; i <= maxRight; i++) {
            if (board[row-i][col+i]){
                return false;
            }
        }
        //if none of the check returns false, means it(the cell) is a safe place to put the queen
        return true;
    }

    public static void display(boolean[][] board) {
        for (boolean[] row:board) {
            for (boolean element:row){
                if (element){
                    System.out.print("Q");
                }
                else{
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
}
