package HashSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class set_misMatch {
    public static void main(String[] args) {
        int[] arr = {1,2,2,4,5};
        System.out.println(Arrays.toString(findErrorNums(arr)));
    }

    public static int[] findErrorNums(int[] nums) {
        //Bitmanipulation se
        // a ^ a = 0 ( The XOR operator ) and 0 ^ a = a
        HashMap<Integer, Integer> hx = new HashMap<>();
        int double_no = 0;
        int missing_no = 0;

        for(int i = 0; i < nums.length ; i++) {
            if(hx.containsKey(nums[i])) {
                int temp = hx.get(nums[i]);
                hx.put(nums[i],temp + 1);
            } else {
                hx.put(nums[i], 1 );
            }

        }

        for(int i = 1; i < nums.length ; i++) {
            if(!hx.containsKey(i)) {
                missing_no = i;
            }

            if(hx.get(nums[i]) == 2) {
                double_no = nums[i];
            }
        }

        return new int[] {double_no, missing_no};
    }
}
