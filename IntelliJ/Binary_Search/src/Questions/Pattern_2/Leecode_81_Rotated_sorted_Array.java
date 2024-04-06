package Questions.Pattern_2;

public class Leecode_81_Rotated_sorted_Array
{
    //this comes with a twist that the elements in the array may be duplicate
    public static void main(String[] args)
    {
        //https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
        int[] nums = {4,4,4,4,4,4,0,1,1,4};
        int target = 1;

        System.out.println(search2(nums,target));
    }

    public static boolean search2(int[] nums, int target) {
        //this is another method for finding the answer without finding the pivot

        //first we define our initial searching space
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo)/2 ;

            //now check
            if(nums[mid] == target) {
                return true;
            }
            if(nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
                //if this is the case then we're stuck with a duplicate ele
                //and hence we're unable to decide whether the right part is sorted
                //or the left part
                lo++;
                hi--;
            } else if(nums[mid] <= nums[hi]) {
                //"else if" because maybe doing the above operation of lo++ and hi--
                // things may go
                //out of bound, so we do one iteration and check lo <= hi
                //let's say when there is just one element
                //or in this case : [1,3,5]

                //means that we're on the right side of the array
                //hence we can say the part [mid - hi] is sorted
                //now check if our target lies in this segment
                if(target >= nums[mid] && target <= nums[hi]) {
                    //so apply BS here
                    //and reject the other part
                    lo = mid + 1;
                } else {
                    //if this is not the case, then move left side
                    hi = mid - 1;
                }

            } else {
                //we're on the left side of the array
                //hence we can say that the part [lo - mid ] is sorted
                if(target >= nums[lo] && target <= nums[mid]) {
                    //then find here and discard the right part
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }

        return false;
    }
    public static boolean search(int[] nums, int target)
    {
        int pivot = findPivotwithDuplicates(nums);

        //case 1 :
        //if you did not find the pivot then the array is not rotated
        if (pivot==-1)
        {
            //just do normal binary search
            return nums[0] == target;
        }
        //when you've found the pivot
        //Case 1:
        if (nums[pivot]==target)
        {
            return true;
        }
        //Case 2 : target element > start element hence, we search from start till pivot -1
        if (target>=nums[0])
        {
            return ( BinarySearch(nums, target,0,pivot-1));

        }
        return BinarySearch(nums,target,pivot+1, nums.length-1);
        //search space is reduced to pivot + 1 till end
    }
    public static int findPivotwithDuplicates(int[] arr)
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
//            if (arr[start]>arr[middle])
//            {
//                end = middle-1;
//            }
//            else
//            {
//                start = middle + 1;
//            }
            //this above condition will be only different as maybe start mid and end will be same
            //then this condition will fail
            //hence if elements at start, middle and end are equal then skip start and end

            if (arr[start]==arr[middle]&&arr[middle]==arr[end])
            {
                //skip the duplicates

                //but what if these elements at start and end were the pivots?
                //hence check if start and end are pivots
                if (start>middle && arr[start]>arr[start+1])
                {
                    //then start will the pivot
                    return start;
                }
                start++;
                if (end>middle && arr[end]>arr[end-1])
                {
                    //then end will the pivot
                    return end;
                }

                end--;
            }
        }
        return -1;//when element not found
    }
    static boolean BinarySearch(int[] arr,int target,int start,int end)
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
                return true;
            }
        }
        return false;

    }
}
