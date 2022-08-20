import java.util.Arrays;

public class Functions
{
    public static void main(String[] args) {
        int [] nums = {2,3,4,5};
        System.out.println(Arrays.toString(nums));
        change(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void change(int[] nums) {
        nums[0]=99;
    }
}
