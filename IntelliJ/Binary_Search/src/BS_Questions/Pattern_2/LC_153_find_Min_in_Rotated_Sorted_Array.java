package BS_Questions.Pattern_2;

public class LC_153_find_Min_in_Rotated_Sorted_Array {
    public static void main(String[] args) {

    }

    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        int potential_ans = nums[0];

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            //check which of the part is sorted
            if(nums[mid] <= nums[hi]) {
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
