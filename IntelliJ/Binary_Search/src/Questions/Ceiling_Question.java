package Questions;

public class Ceiling_Question
{
    public static void main(String[] args)
    {
//        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,13,14,15,16};
        int [] arr = {90,90,90,87,75,18,15,13,2,1};
        System.out.println(Ceiling(arr,91));

    }

    public static int Ceiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1; //imp : -1 karna

        //firstly finding whether the array is ascending or descending sorted
        boolean isAscending = arr[start] < arr[end];
//        if(isAscending)
//        {
//            if ()
//            return -1;
//        }

        while (start <= end) {
            //find the middle element
//            int middle = (start+end)/2;
            /* might be possible that (start+ end) exceeds the range of int in JAVA
             * hence it may give you some error
             * Hence a better way to find mid will be */
            int middle = start + (end - start) / 2;
            //common for both :
            if (arr[middle] == target) {
                //ans found
                return arr[middle];
            } else
            {
                //for ascending
                if (arr[middle]<target && arr[middle+1]>target) {
                    return arr[middle + 1];
                }
                //for descending
                if (arr[middle]>target && arr[middle+1]<target)
                {
                    return arr[middle];
                }
            }

            //different :
            if (isAscending) {
                if (target>arr[end])
                {
                    return -1;
                }
                if (arr[middle] > target) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else {
                if (target<arr[end])
                {
                    return arr[end];
                }

                if (arr[middle] < target) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }

            }


        }
        return -1;

    }
}