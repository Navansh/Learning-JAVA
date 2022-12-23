package Sorting;

import java.util.Arrays;

public class Quick_Sort
{
    public static void main(String[] args) {
        int[] arr = {43,24,324,24,235542};
        QuickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void QuickSort(int[] arr,int low,int high)
    {
        //these vars are used because we aren't creating a new array, hence we use these vars
        // to point to specific indices of the OG array
        if (low>=high)
        {
            return;
        }
//        low, high - > for figuring out which array we choose to work on
        // start, end -> for swapping
        int start = low;
        int end = high;
        int mid = start+(end-start)/2;

        //let's say we take the middle element as pivot
        int pivot = arr[mid];

        //this code will make the pivot at correct place
        //condition for swapping
        while (start<=end)
        {
            while (arr[start]<pivot)
            {
                start++;
            }
            while (arr[end]>pivot)
            {
                end--;
            }
            //this will come out when if:
            //when the whole array is sorted or it hits the violation

            //hence we'll only swap, when there is violation and hence we check for that by
            //hence this also a reason why if its already sorted then it won't swap unlike Merge Sort
            if (start<=end)
            {
                //then only swap the elements
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                //and once we swap we do
                start++;
                end--;
            }
        }
        //now my pivot is at correct index, sort the two halves now
        QuickSort(arr,low,end);
        //ending at end because then end would have moved to the left side of the array, violating the condition start<=end
        //hence the first division take place at low->end and as then start would have moved +1 and hence to the right of the
        //array
        //so the other half is start->high
        QuickSort(arr,start,high);
    }
}
