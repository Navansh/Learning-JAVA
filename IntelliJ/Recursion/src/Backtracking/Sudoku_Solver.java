package Backtracking;

public class Sudoku_Solver {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if (solve(board)){
            display(board);
        }
        else {
            System.out.println("Cannot solve");
        }
    }


    static boolean solve(int[][] board){
        //by default we assume the empty places or the places to be filled are initialized with 0
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyleft = true;

        //this is the way we are replacing r,c from the arguments
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]==0){
                    row = i;
                    col = j;
                    emptyleft = false;
                    break;
                }
            }
            //if you've found some empty element in the row then break,
            if (emptyleft==false){
                break;
            }
        }

        if (emptyleft==true){
            return true;
            //this means sudoku is solved
        }

        //backtrack
        for (int number = 1; number <= 9; number++) {
            //0 cannot be an answer, that's why we start from 1
            if (isSafe(board,row,col,number)){
                board[row][col] = number;
                if (solve(board)){
                    return true;
                    //you've found your answer

                } else {
                    //backtrack
                    board[row][col] = 0;

                }
            }
        }
        return false;
    }

    private static void display(int[][] board) {
        for (int[] row:board){
            for (int number:row){
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] board, int row, int col,int num){
        //check the row
        for (int i = 0; i < board.length; i++) {
            //check if the number is in the row or not
            if (board[row][i]==num){
                return false;
            }
        }
        //check the col
        for (int[] ints : board) {
            //check if the number is in the row or not
            if (ints[col] == num) {
                return false;
            }
        }

        //square box check ****IMP*****
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - (row%sqrt);
        int colStart = col - (col%sqrt);

        for (int row1 = rowStart; row1 < rowStart+sqrt; row1++) {
            for (int col1 = colStart; col1 < colStart+sqrt; col1++) {
                if (board[row1][col1]==num){
                    return false;
                }

            }
        }
        return true;
    }
}
