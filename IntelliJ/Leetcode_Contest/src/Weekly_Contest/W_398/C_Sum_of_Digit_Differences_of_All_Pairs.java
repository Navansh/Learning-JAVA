package Weekly_Contest.W_398;

import java.util.HashMap;

public class C_Sum_of_Digit_Differences_of_All_Pairs {
    public static void main(String[] args) {

    }

    public long sumDigitDifferencesAlso(int[] nums) {
        HashMap<Integer, Integer> hx = new HashMap<>();
        //here we'll store the n

        int digitLength = String.valueOf(nums[0]).length();

        int[][] pos = new int[nums[0]][0];

        return 0;
    }

    public long sumDigitDifferences(int[] nums) {
        // Convert all numbers to string to easily access each digit
        int numCount = nums.length;
        String[] numStrings = new String[numCount];
        for (int i = 0; i < numCount; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }

        // Assumption: All numbers have the same number of digits
        //as given in the question itself
        int numLength = numStrings[0].length();

        // Initialize a 2D array to count occurrences of each digit (0-9) at each position
        int[][] digitCounts = new int[numLength][10];

        // Fill digit counts
        for (String num : numStrings) {
            for (int pos = 0; pos < numLength; pos++) {
                digitCounts[pos][num.charAt(pos) - '0']++;
            }
        }

        long totalDifferences = 0;

        // Calculate digit differences
        for (int pos = 0; pos < numLength; pos++) {
            for (int digit = 0; digit < 10; digit++) {
                long count = digitCounts[pos][digit];
                totalDifferences += count * (numCount - count);
            }
        }

        // Each pair difference is counted twice, so divide by 2
        return totalDifferences / 2;
    }
}
