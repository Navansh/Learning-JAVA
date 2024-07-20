package Questions.Array;

public class Find_valid_matrix_given_row_and_col {
    public static void main(String[] args) {
        //https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/description/?envType=daily-question&envId=2024-07-20
    }

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;

        int[][] matrix = new int[m][n];

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            //ek bhi agar out of bounds jaata hai then rest mein
            //0 hi fill hoga, as then woh toh poora satisfies ho hi
            //gya

            matrix[i][j] = Math.min(rowSum[i], colSum[j]);
            rowSum[i] -= matrix[i][j];
            colSum[j] -= matrix[i][j];

            if(rowSum[i] == 0) {
                //then iss row ka kaam hogya
                i++;
            }

            if(colSum[j] == 0) {
                //then iss col ka kaam hogya and baaki ele
                //automatically 0 hogye
                j++;
            }
        }

        return matrix;
    }
}
