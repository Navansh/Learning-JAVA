package Search_in_2D_Arrays;

import java.util.Arrays;

public class Row_Col_Sorted_Matrix
{
    //searching in a row and col wise sorted matrix
    public static void main(String[] args)
    {
        int[][] arr = {
                {10,20,30,40,51},
                {15,25,35,45,55},
                {28,29,37,49,57},
                {33,34,38,50,59}
        };
        System.out.println(Arrays.toString(search(arr,55)));
    }
    public static int[] search(int[][] matrix, int target)
    {
        int row = 0;
        int col = matrix[0].length - 1;
        // Special attention above to calculate the number of cols in 2D Array
        // be cautious matrix may be empty hence add check for that

        while(row < matrix.length && col > 0)
        {
            if (matrix[row][col]==target)
            {
                return new int[]{row,col};
            }
            if (matrix[row][col]<target)
            {
                row++;
            }
            else if (matrix[row][col]>target)
            {
                col--;
            }
        }
        return new int[]{-1,-1};
    }
}


