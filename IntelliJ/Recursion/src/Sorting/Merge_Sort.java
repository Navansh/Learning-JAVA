package Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Merge_Sort
{
    public static void main(String[] args) {
        int[] arr = {1,44,24,24,5,24,53,46,64};

        arr = MergeSort(arr);
        //updating the original array
        System.out.println(Arrays.toString(arr));
    }
    public static int[] MergeSort(int[] arr){
        //base condition
        if (arr.length==1)
        {
            return arr;
        }
        //take the middle element and split the array into 2
        int mid = arr.length/2;

        //now get the ans from left and right
        int[] left = MergeSort(Arrays.copyOfRange(arr,0,mid));
        //copy of CREATES a new Array with the given range, hence we are not modifying
        //the original array
        //hence same value(within given range) but diff object
        int[] right = MergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        //going from mid as the left side value(from) is inclusive in this function

        return Merger(left,right);
    }

    private static int[] Merger(int[] first, int[] second) {
        //now we create a new array
        int[] mix = new int[first.length+ second.length];

        int i = 0;
        int j = 0;
        int k = 0;
        //these are 3 variable which we'll use to point at certain indices while we are
        // sorting the array

        while(i< first.length&&j<second.length)
        {
            //now check which element is smaller
            if (first[i] <= second[j]){
                mix[k] = first[i];
                i++;
            }
            else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        //it got out of this loop means either the new array has been filled ->this happens when the size of both arrays is same,
        //or
        //we hit the condition of i or j for one of the loop, hence there are some elements still left in either of the array
        //copy the remaining elements from either of the array into the main array
        while (i< first.length)
        {
            mix[k] = first[i];
            i++;
            k++;
        }
        //either one of these loops will run due to explanation above provided
        while (j < second.length)
        {
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }
}
