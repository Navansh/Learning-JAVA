package Question;

public class Leetcode_287_Find_Duplicate
{
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate2(nums));
    }
    public static int findDuplicate(int[] nums) {
        int j = 0;
//        for (int i = 0; i < nums.length; i++)
//        //we will only move the i forwards when it is at its correct index
//        {
//            while (nums[i] < nums.length && nums[nums[i]]!=nums[i] )
//            {
//                Swap(nums, i, nums[i]);
//            }
//        }
        //ismein maybe complexity increase ho rhi hai
        while (j < nums.length)
        {
            if (nums[j]!=j+1)
            {
                int correct_index= nums[j]-1;
                if (nums[j]!=nums[correct_index])
                {
                    Swap(nums,j,correct_index);
                }
                else return nums[j];
            }
            else
                j++;

        }
        return -1;
    }

    public static int findDuplicate2(int[] nums) {
        //same concept, also a little bit slower
        //use the concept of cyclic sort
        //as the numbers are from 1 to n and we have n + 1 size array
        //means correct index for each element = value - 1

        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i + 1) {
                //means the current index doesn't have its correct element
                //so swap the current element with its correct index
                int correct_index = nums[i] - 1;
                if(nums[correct_index] == nums[i]) {
                    break;
                }
                Swap(nums, i, correct_index);
            }
        }

        //now after this is done, there should be one element which is
        //not at its correct index, just find that and that is our answer
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return nums[i];
            }
        }

        return -1;
    }
    public static void Swap(int[] arr,int first,int second) {
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second] = temp;
    }
}
