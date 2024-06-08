import java.util.Arrays;

public class Search_in_2D_Array {
    public static void main(String[] args) {
        int[][] arr = {
                {2, 3, 4},
                {5, 6, 7},
                {7, 8, 5}
        };
        int[] row_col = {0, 0};
        int[] ans = Searchme(arr, 55);//return format :start index and end index {row,col}
        System.out.println(Arrays.toString(ans));
        System.out.println(Givemax(arr));
        System.out.println(Integer.MIN_VALUE);
    }

    static int[] Searchme(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    return new int[]{i, j};
                }
            }

        }
        return new int[]{-1, -1};
        //basically we use 2 for loops
    }

    static int Givemax(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int[] i : arr) {
            for (int j : i) {
                if (j > max) {
                    max = j;
                }
            }
        }
        return max;
        //basically we use 2 for loops
    }
    //similarly we can implement for minimum






















}
