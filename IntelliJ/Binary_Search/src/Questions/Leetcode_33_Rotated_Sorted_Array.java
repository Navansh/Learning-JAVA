package Questions;
//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class Leetcode_33_Rotated_Sorted_Array
{
    public static void main(String[] args)
    {
        int[] nums = {4,5,5,6,7,0,1,2};
        int target = 3;

        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target)
    {
        int pivot = findPivot(nums);

        //case 1 :
        //if you did not find the pivot then the array is not rotated
        if (pivot==-1)
        {
            //just do normal binary search
            return BinarySearch(nums,target,0,nums.length -1);
        }
        //when you've found the pivot
        //Case 1:
        if (nums[pivot]==target)
        {
            return pivot;
        }
        //Case 2 : target element > start element hence, we search from start till pivot -1
        if (target>=nums[0])
        {
            return BinarySearch(nums, target,0,pivot-1);
        }
        return BinarySearch(nums,target,pivot+1, nums.length-1);
        //search space is reduced to pivot + 1 till end
    }
    public static int findPivot(int[] arr)
    {
        int start = 0;
        int end = arr.length - 1;

        //4 cases over here\
        while(start<=end)
        {
            int middle = start + (end - start)/2;
            //if first condition is false it won't even check for the next condition
            if ( middle<end && arr[middle]>arr[middle+1]) //this condition is very important as it will ensure that mid+1
                //doesn't go out of bounds
            {
                return middle;
            }
            if (middle > start && arr[middle]<arr[middle-1] )//same here so that mid -1 doesn't go out of bound
            {
                return (middle -1);
            }
            if (arr[start]>=arr[middle])
            {
                end = middle-1;
            }
            else
            {
                start = middle + 1;
            }
        }
        return -1;//when element not found
    }
    static int BinarySearch(int[] arr,int target,int start,int end)
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

