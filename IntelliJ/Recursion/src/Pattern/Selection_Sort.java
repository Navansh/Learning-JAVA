package Pattern;

import java.util.Arrays;

public class Selection_Sort
{
    public static void main(String[] args) {
        //remember we start row here from arr.length
        int[] arr = {4,23,24,42,1};
        SelectionSort(arr, arr.length, 0,0);
        System.out.println(Arrays.toString(arr));
    }
    public static void SelectionSort(int[] arr,int row,int col,int max)
    {
        if (row==0)
        {
            return;
        }
        if (col<row) {
            //this loop is for current row, and this is where we have to maintain the maximum
            if (arr[col]>arr[max])
            {
                SelectionSort(arr,row, col + 1,col);
            }
            else {
                SelectionSort(arr,row, col + 1,max);
                //max remains as it is
            }
        }
        else {
            //this else hits when you have evaluated the whole line, which means now you have found
            // max element
            //, so now you swap the max the element with the last element of the row which is at index
            //row - 1;
            int temp = arr[row-1];
            arr[row-1] = arr[max];
            arr[max] = temp;
            //now we are done with this, now we decrease or length of consideration and assume
            //index 0 element as max and start again
            SelectionSort(arr,row-1,0,max);
        }
    }
}
