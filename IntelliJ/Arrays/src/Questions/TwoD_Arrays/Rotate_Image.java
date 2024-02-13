package Questions.TwoD_Arrays;

public class Rotate_Image {
    public static void main(String[] args) {
        //https://leetcode.com/problems/rotate-image/description/
    }

    public static void rotate(int[][] matrix) {
        //take the transpose of the matrix and then reverse it row-wise

        //take the transpose
        //using the bottom triangle

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                //swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //now reverse each row
        for (int i = 0; i < matrix.length; i++) {
            //swapping the array using the 2 pointer approach
            int start = 0;
            int end = matrix[i].length - 1;

            while(start < end) {
                //swap them
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }

        }
        
    }


}
