package Arrays;

import java.util.Arrays;

public class Sort_the_Jumbled_Integers {
    public static void main(String[] args) {
        //https://leetcode.com/problems/sort-the-jumbled-numbers/?envType=daily-question&envId=2024-07-24
        int a = 65;
        System.out.println((char) a);
    }
    
    class Pair implements Comparable<Pair> {
        int og;
        int changed;
        
        Pair(int og, int changed) {
            this.og = og;
            this.changed = changed;
        }
        @Override
        public int compareTo(Pair o) {
            return this.changed - o.changed;
        }
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        //convert the number to the new number according to mapping
        Pair[] arr = new Pair[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], (int) mappedNum(nums[i], mapping));
        }

        Arrays.sort(arr);
        //this handles inplace sorting that we want in this question
        int[] ans = new int[nums.length];

        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i].og;
        }

        return ans;
    }

    private long mappedNum(int num, int[] mapping) {
        String numStr = Integer.toString(num);
        char[] arr = numStr.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i] - '0';
            arr[i] = (char) ((char) mapping[digit] + '0');
        }

        //convert character array to int
        //this may overflow
        long mappedNum = Long.parseLong(new String(arr));
        return mappedNum;
    }
}
