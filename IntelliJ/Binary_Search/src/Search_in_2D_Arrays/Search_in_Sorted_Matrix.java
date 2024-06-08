package Search_in_2D_Arrays;

import java.util.Arrays;

public class Search_in_Sorted_Matrix
{
    public static void main(String[] args) {
        int[][] arr = {
                {10,20,30,40,50},
                {60,70,80,90,100},
                {110,120,130,140,150},
                {160,170,180,190,200}
        };
        System.out.println(Arrays.toString(search(arr,180)));
    }
    static int[] search(int[][] matrix, int target)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // be cautious matrix may be empty
        if (rows==1)
        {
            return BinarySearch(matrix,0,0,cols - 1,target);
        }

        //run the loop till 2 rows are remaining
        //hence
        int row_start = 0;
        int row_end = rows- 1;
        int mid_col = cols/2;

        while (row_start<(row_end-1))
        //while this is true it will have more than 2 rows which we have to eliminate
        {
             int mid = row_start + (row_end-row_start)/2;
             if(matrix[mid][mid_col]==target)
             {
                 return new int[]{mid,mid_col};
             }
             if (matrix[mid][mid_col]<target)
             {
                 row_start = mid;
             }
             else
             {
                 row_end = mid ;
             }
        }

        //now we have 2 rows
        //check whether the target is in col of 2 rows
        if(matrix[row_start][mid_col] ==target)
        {
            return new int[]{row_start,mid_col};
        }
        if (matrix[row_start + 1][mid_col]==target)
        {
            return new int[]{row_start+1,mid_col};
        }

        //search in 1st half ( not exactly half we can say part)
        if (target <= matrix[row_start][mid_col-1])
        {
            return BinarySearch(matrix,row_start,0,mid_col-1,target);
        }
        //search in 2nd half( not exactly half we can say part)
        if (target >=matrix[row_start][mid_col+1]&&target<=matrix[row_start+1][cols-1])
        {
            return BinarySearch(matrix,row_start,mid_col+1,cols-1,target);
        }
        //search in 3rd half( not exactly half we can say part)
        if (target <=matrix[row_start+1][mid_col-1])
        {
            return BinarySearch(matrix,row_start+1,0,mid_col-1,target);
        }
        //search in 4th half( not exactly half we can say part)
        if (target >=matrix[row_start+1][mid_col+1])
        {
            return BinarySearch(matrix,row_start+1,mid_col+1,cols-1,target);
        }

        return new int[]{-1,-1};

    }
    //code to search in the row provided between the cols provided
    static int[] BinarySearch(int[][] matrix, int row,int col_start,int col_end,int target)
    {
        while(col_start<=col_end)
        {
            int mid = col_start + (col_end-col_start)/2;
            if (matrix[row][mid]==target)
            {
                return new int[] {row,mid};
            }
            if (matrix[row][mid]<target)
            {
                col_start = mid +1 ;
            }
            else {
                col_end = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }
}
