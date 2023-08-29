package Questions;

public class Leetcode_81_Different {
    public static boolean search(int[] nums, int target) {
        int pivot = findPivotWithDuplicates(nums);

        boolean ans1 = false;
        boolean ans2 = false;

        if(pivot != - 1)  {
            ans1 =  BinarySearch(nums,target,0,pivot);
            if(ans1 == false) {
                ans2 = BinarySearch(nums,target,pivot + 1, nums.length - 1);
                return ans2;
            }

        } else {
            ans1 = BinarySearch(nums,target,0,nums.length - 1);
        }

        return ans1;
    }

    public static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <=end) {

            int mid = start + (end-start)/2 ;

            //a condition for removing the duplicate condition, where our checks would fail
            if(start != end && arr[start] == arr[mid] && arr[mid] == arr[end]) {
                start++;
                end--;
                // continue;
            }
            if(arr.length < 2) {
                return -1;
            }
            if(mid+ 1 <= (arr.length - 1) && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if(mid > 0 && arr[mid - 1] > arr[mid]) {
                return (mid - 1);
            }
            if(arr[start] > arr[mid]) {
                end = mid - 1;
            } else if(arr[start] < arr[mid]) {
                start = mid + 1;
            }
        }

        return -1;
    }

    static boolean BinarySearch(int[] arr,int target,int start,int end)
    {
        while(start<=end)
        {
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

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1};
        int target = 0;
        boolean ans = search(nums, target);
        System.out.println(ans);
    }
}
