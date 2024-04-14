package Stack_Questions.TwoD_Arrays;

public class Max_Submatrix_sum_of_a_sorted_Matrix {
    public static void main(String[] args) {

    }

    public static int maxSubmatrixSum(int[][] matrix) {
        //calculate the prefixSum

        int[][] pSum = new int[matrix.length][matrix[0].length];

        //create the 2D PrefixSum Array,
        //firstly, doing row-wise prefixSum
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //now traverse each cell in the first row
                //and calculate the prefixSum
                if(j == 0) {
                    pSum[i][j] = matrix[i][j];
                } else {
                    pSum[i][j] = pSum[i][j-1] + matrix[i][j];
                }
            }
        }

        //now, doing colwise sum
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                //j here represents the row
                //we'll start the row from 1, as its anyway not going to change

                //now traverse each cell of a single col in each row
                //and calculate the colwise prefixSum
                pSum[j][i] = pSum[j - 1][i] + pSum[j][i];

            }
        }

        //now try every i,j and check the max sum
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                //hence the top left we are selecting is i,j
                //and bottom left fixing to n - 1, m - 1;
                int row2 = matrix.length - 1;
                int col2 = matrix[0].length - 1;

                int row1 = i;
                int col1 = j;

                int sum = 0;
                sum += pSum[row2][col2];

                if(row1 - 1 >= 0) {
                    //then only we'll subtract
                    sum -= pSum[row1 - 1][col2];
                }

                if(col1 - 1 >= 0) {
                    sum -= pSum[row2][col1 - 1];
                }

                if(row1 - 1 >= 0 && col1 - 1 >= 0) {
                    sum += pSum[row1 - 1][col1 - 1];
                }

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;

    }
}
