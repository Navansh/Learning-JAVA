package Stack_Questions.TwoD_Arrays;

public class Range_Sum_Query_TwoD {
    public static void main(String[] args) {
        //an extension of the range sum Query question, of 1D array
    }

}

class NumMatrix {
    int[][] pSum;
    public NumMatrix(int[][] matrix) {
        //create the prefixSum as soon as the class is initialized
        pSum = new int[matrix.length][matrix[0].length];

        pSum[0][0] = matrix[0][0];

        //create the 2D PrefixSum Array,
        //firstly, doing row-wise prefixSum
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
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
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
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

        return sum;
    }
}
