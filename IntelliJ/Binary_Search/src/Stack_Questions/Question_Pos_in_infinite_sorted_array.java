package Stack_Questions;

public class Question_Pos_in_infinite_sorted_array
{
    public static void main(String[] args)
    {
//        https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
        //start with the chunk of size 2
        int [] arr = {90,90,90,87,75,18,15,13,2,1};
        System.out.println(ans(arr,91));
    }


    static int ans(int[] arr,int target)
    {
        //first we have to find the range
        //hence we start with chunk of size 2
        int start = 0;
        int end = 1;

        //and while the target is greater than the arr[end] keep doubling the chunk size
        //also we'll only check for end as if it is greater than end than obviously it will be greater than arr[start]
        while(target > arr[end])
        {
            int newstart = end +1;
            //now double the box value
            //end = previous end  + sizeofbox*2
            end = end + (end-start + 1)*2; //imp
            start = newstart;

        }
        return BinarySearch(arr,target,start,end);
    }
    static int BinarySearch(int[] arr,int target,int start, int end)
    {

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
