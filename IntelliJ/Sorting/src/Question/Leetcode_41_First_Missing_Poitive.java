package Question;
//https://leetcode.com/problems/first-missing-positive/
public class Leetcode_41_First_Missing_Poitive
{
    public static void main(String[] args)
    {

    }
    public static int firstMissingPositive(int[] nums) {
        int j = 0;
        while (j < nums.length) {
            int correct_index= nums[j]-1;
            if (nums[j] > 0 && nums[j]<=nums.length && nums[j]!=nums[correct_index])
            {
                Swap(nums,j,correct_index);
            }
            else j++;
        }
        //now search for first missing number
        for (int i = 0; i < nums.length ; i++)
        //we want it to traverse the whole array and not leave the last element
        {
            if (nums[i]!=i+1)
                return i+1;

        }
        return nums.length+1;
    }

    public static void Swap(int[] arr,int first,int second) {
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second] = temp;
    }
}
