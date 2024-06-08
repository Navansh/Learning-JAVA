package Weekly_Contest.W_398;

public class A_Special_Array_1 {
    public static void main(String[] args) {

    }

    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if((nums[i] % 2 == 0 && nums[i- 1] %2 != 0) || nums[i] %2 != 0 && nums[i - 1] %2 == 0) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
