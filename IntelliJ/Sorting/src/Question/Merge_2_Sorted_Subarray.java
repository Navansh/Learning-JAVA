package Question;

import java.util.Arrays;

public class Merge_2_Sorted_Subarray {
    public static void main(String[] args) {
        int[] arr = {4, 8 , -1, 2, 6, 9, 11, 3, 4,7,13,0 };
        System.out.println(Arrays.toString(Merge2Subarrays(arr, 2,6,9)));
    }

    public static int[] Merge2Subarrays(int[] arr, int start, int mid, int end) {
        //given the start, mid and end for the array arr
        //1st part is : s to m
        //2nd part is : m + 1 to e

        //create a temp array :
        int[] temp = new int[end-start+ 1];

        //place the pointers
        int p1 = start;
        int p2 = mid + 1;
        int p3 = 0;

        //not modifying the start index as we're gonna need it later

        while (p1 <= mid && p2 <= end) {
            if(arr[p1] < arr[p2]) {
                temp[p3] = arr[p1];
                p1++;
                p3++;
            } else {
                temp[p3] = arr[p2];
                p2++;
                p3++;
            }
        }

        //out of the loop means either complete or one of the condition broke
        while (p1 <= mid ) {
            //copy all the ele
            temp[p3] = arr[p1];
            p1++;
            p3++;
        }

        while (p2 <= end) {
            temp[p3] = arr[p2];
            p2++;
            p3++;
        }

        //now its complete, just copy temp to the OG Array
        for (int i = 0; i < temp.length; i++) {
            arr[start] = temp[i];
            start++;
        }

        return arr;
    }
}
