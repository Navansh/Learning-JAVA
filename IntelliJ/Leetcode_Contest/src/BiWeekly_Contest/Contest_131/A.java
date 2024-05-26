package BiWeekly_Contest.Contest_131;

import java.util.HashMap;

public class A {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3};
        System.out.println(duplicateNumbersXOR(arr));
    }

    public static int duplicateNumbersXOR(int[] nums) {
        //use a HashMap as nums.length is 50 only so not much effect also
        HashMap<Integer, Integer> hx = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(hx.containsKey(nums[i])) {
                int temp = hx.get(nums[i]);
                hx.put(nums[i], temp + 1);
            } else{
                hx.put(nums[i], 1);
            }
        }

        int xor = 0;

        for(int i : hx.keySet()) {
            if(hx.get(i) == 2) {
                xor = xor ^ i;
            }
        }

        return xor;
    }
}
