package BS_Questions.Matrix;

public class Search_in_Matrix_2 {
    public static void main(String[] args) {
        //https://leetcode.com/problems/search-a-2d-matrix-ii/
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        //place 2 pointers at top right corner of the matrix
        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >=0) {
            //check for the ele in the i,j cell
            //if not move down or left
            if(matrix[i][j] == target) {
                return true;
            } else if(target > matrix[i][j]) {
                //go down
                i++;
            } else {
                //go left
                j--;
            }
        }

        return false;

    }
}
