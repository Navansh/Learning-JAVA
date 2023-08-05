package Questions;

public class Ceiling_Question_Approach_2 {
    public static void main(String[] args) {
       // int[] arr = {1, 4, 12, 14, 34, 55, 65, 78, 85, 333};
        int[] arr = {191,4,3,2,1};
        System.out.println(BinarySearch(arr, 45));
    }
    //binary search is the optimised way to search for any element
    // implementing binary search algo



    public static int BinarySearch(int[] arr, int target)
    {
        int start = 0;
        int end = arr.length - 1; //imp : -1 karna

        //firstly finding whether the array is ascending or descending sorted
        boolean isAscending = arr[start] < arr[end];

        while(start<=end)
        {
            //find the middle element
//            int middle = (start+end)/2;
            /* might be possible that (start+ end) exceeds the range of int in JAVA
             * hence it may give you some error
             * Hence a better way to find mid will be */
            int middle = start + (end - start)/2;
            //common for both :
            if(arr[middle]==target)
            {
                //ans found
                return arr[middle];
            }

            //different :
            if(isAscending)
            {
                if (arr[middle]>target)
                {
                    end = middle -1;
                }
                else
                {
                    start = middle + 1;
                }
            }
            else {
                if (arr[middle]<target)
                {
                    end = middle -1;
                }
                else
                {
                    start = middle + 1;
                }

            }
        } 
        return arr[start];
    }

}