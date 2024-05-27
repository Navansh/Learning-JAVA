package Array_Questions.TwoD_Arrays;

public class Transpose_of_Matrix {
    public static void main(String[] args) {
        //do it in O(1) Space
    }

    public static void transposer(int[][] arr) {
        //this is for NxN matrix*****
        //we can travel two halp triangle, here we're choosing lower half
        //explaination in copy
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

}
