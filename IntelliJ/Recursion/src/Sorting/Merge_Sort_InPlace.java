package Sorting;

import java.util.Arrays;

public class Merge_Sort_InPlace
{
    public static void main(String[] args) {
        int[] arr = {1,44,24,24,5,6};
        MergeSortInPlace(arr,0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void MergeSortInPlace(int[] arr,int start,int end){
        //base condition
        if (end-start==1)
        //here end - start means the length of the array
        {
            return;
        }
        //take the middle element and split the array into 2
        int mid = start+(end-start)/2;

        //now get the ans from left and right
        MergeSortInPlace(arr,start,mid);
        //modifying the same array
        MergeSortInPlace(arr,mid,end);

        MergerInPlace(arr,start,mid,end);
    }

    private static void MergerInPlace(int[] arr, int start, int mid, int end) {
        int[] mix = new int[end-start];

        int i = start;
        int j = mid;
        int k = 0;

        while(i< mid&&j<end)
        {
            //now check which element is smaller
            if (arr[i] <= arr[j]){
                mix[k] = arr[i];
                i++;
            }
            else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i< mid)
        {
            mix[k] = arr[i];
            i++;
            k++;
        }
        //either one of these loops will run due to explanation above provided
        while (j < end)
        {
            mix[k] = arr[j];
            j++;
            k++;
        }

        //till now, you have your ans in mix, now you need to copy it to the original array
        System.arraycopy(mix, 0, arr, start, mix.length);
        //copy from mix to arr;
    }

}
