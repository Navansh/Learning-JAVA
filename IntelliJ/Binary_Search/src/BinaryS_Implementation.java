public class BinaryS_Implementation {
    public static void main(String[] args)
    {
       //binary search is the optimised way to search for any element
        // implementing binary search algo
        int[] arr={1,4,12,14,34,55,65,78,85,333};
        System.out.println(BinarySearch(arr,14));


    }
    //function which return the index
    //return -1 if it does not exist
    static int BinarySearch(int[] arr,int target)
    {
        int start = 0;
        int end = arr.length - 1; //imp : -1 karna

        while(start<=end)
        {
            //find the middle element
//            int middle = (start+end)/2;
            /* might be possible that (start+ end) exceeds the range of int in JAVA
            * hence it may give you some error
           * Hence a better way to find mid will be */
            int middle = start + (end - start)/2;
            if (arr[middle]>target)
            {
                end = middle -1;
            }
            else if (arr[middle]<target)
            {
                start = middle + 1;
            }
            else
            {
                //ans found
                return middle;
            }
        }
        return -1;

    }
}