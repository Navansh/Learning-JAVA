package Stack_Questions.TwoD_Arrays;

public class Sum_of_all_Submatrix {
    public static void main(String[] args) {

    }

    public static int allSubmatrixSum(int[][] matrix) {
        int ans = 0;

        //using contribution technique
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[j].length; j++) {
                int validTopLeft = (i + 1) * (j + 1);
                int validBottomRight = (matrix.length - i) * (matrix[0].length - j);
                int contribution = validTopLeft * validBottomRight * matrix[i][j];
                ans += contribution;
            }
        }

        return ans;
    }
}
