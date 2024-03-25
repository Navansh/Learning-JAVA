import java.util.Arrays;

public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,4,3,2,1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if(start == end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge2Subarrays(arr, start, mid, end);
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        //TC : O(N + M)
        //SC : O(N + M)
        //as the res array even though is output will be counted here for SC
        //as its part of a bigger problem, and therefore not the final o/p in that case
        //***** IMP^^^^^^^^^^^

        //both arrays are sorted, create a new array which is made my merging these 2
        //arrays making sure that the resultant array is also sorted
        int n = arr1.length;
        int m = arr2.length;
        int[] res = new int[n + m];

        int p1 = 0;
        //will keep track of the index for arr1
        int p2 = 0;
        //for arr2
        int p3 = 0;
        //for arr3

        while (p1 < n && p2 < m) {
            //do inter comparison between the elements of the 2 arrays at p1 and p2 index
            if(arr1[p1] < arr2[p2]) {
                //add this to the resultant array
                res[p3] = arr1[p1];
                p1++;
                p3++;
            } else {
                //arr2 element is smaller
                res[p3] = arr2[p2];
                p2++;
                p3++;
            }
        }

        //loop must be broken if all the placing was done, or if
        //or if one array was larger than the other and its elements are remaining
        //so just copy all the remaining ele in the res array

        while (p1 < n) {
            res[p3] = arr1[p1];
            p1++;
            p3++;
        }

        while (p2 < m) {
            res[p3] = arr2[p2];
            p2++;
            p3++;
        }

        return res;
    }

    public static int[] merge2Subarrays(int[] arr, int start, int mid, int end) {
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
