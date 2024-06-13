package HashMap_Questions;

import java.util.HashMap;

public class Longest_Consecutive_Sequence {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hx = new HashMap<>();

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(hx.containsKey(num)) {
                //if the number is already processed then skip it
                continue;
            }
            int startPoint = num;
            int endPoint = num;
            //for any number who hasn't appeared we initialize it
            //with these starting points, that is the number itself

            //now check if its prev number is present
            if(hx.containsKey(num - 1)) {
                //meaning we have now got a new starting point for
                //our sequence
                startPoint = startPoint - hx.get(num - 1);
            }

            if(hx.containsKey(num + 1)) {
                //meaning we have now got a new ending point for
                //our sequence
                endPoint = endPoint + hx.get(num + 1);
            }

            int length = endPoint - startPoint + 1;
            hx.put(startPoint, length);
            hx.put(endPoint, length);

            maxLength = Math.max(maxLength, length);

            if(startPoint != num && endPoint != num) {
                hx.put(num, 1);
            }
            //this is for the last case, when our number's immediate
            //start and end point are available,
            //so our num won't be inserted into the hashmap
            //but its start and end point will be updated
            //hence if the number appears once again, then it will
            //again alter start and end point which we don't want

        }

        return maxLength;
    }
}
