package Question;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_442_All_Duplicates_in_Array
{
    public static void main(String[] args)
    {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }
    public static List<Integer> findDuplicates(int[] nums)
    {
        List<Integer> ans = new ArrayList<>();
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
                else
                {
                    ans.add(j);
                    j++;
                }
            }
            else
                j++;

        }
        return ans;
    }
    public static void Swap(int[] arr,int first,int second)
    {
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second] = temp;
    }
}
