package Questions.Pattern_2;

import java.util.ArrayList;
import java.util.List;

public class LC_154_Find_Min_in_Rotated_Sorted_Array_w_Duplicates {
    public static void main(String[] args) {
        //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

    }

    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        List<Integer> listerr = new ArrayList<>();



        int potential_ans = nums[0];

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
                //this is the duplicate waali condition
                //so do this as check mid for the potential ans and move ahead both
                //pointers

                potential_ans = Math.min(potential_ans, nums[mid]);
                lo++;
                hi--;

            } else if(nums[mid] <= nums[hi]) {
                //"else if" because maybe doing the above operation of lo++ and hi--
                // things may go
                //out of bound, so we do one iteration and check lo <= hi
                //let's say when there is just one element
                //or in this case : [1,3,5]

                //now check which of the part is sorted

                //it means right is sorted
                //hence the sorted array ranges from [mid, hi]
                //hence check this part's potential ans with the overall ans
                potential_ans = Math.min(potential_ans,nums[mid]);

                //now search in unsorted array
                hi = mid - 1;
            } else {
                //the left part is sorted
                //left part goes from [lo, mid] which is sorted
                //hence check this part's potential ans with the overall ans
                potential_ans = Math.min(potential_ans, nums[lo]);

                //now search in unsorted part
                lo = mid + 1;
            }
        }

        return potential_ans;

    }
}
