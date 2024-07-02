package DP_Questions.Cut_based_Problems;

import java.util.Arrays;

public class Burst_Balloons {
    public static void main(String[] args) {
        //https://leetcode.com/problems/burst-balloons/description/
    }

    public int maxCoins(int[] nums) {
        int[] newArr = new int[nums.length + 2];
        newArr[0] = 1;
        newArr[nums.length + 1] = 1;
        //first and last index par dummy element bana diya 1 value
        //kaa, so as to help in edge cases

        for (int i = 1; i <= nums.length; i++) {
            newArr[i] = nums[i - 1];
        }

        int[][] dp = new int[newArr.length][newArr.length];

        for(int[] dpx : dp) {
            Arrays.fill(dpx, -1);
        }

        //and we'll iterate between start and end
        int start = 0;
        int end = newArr.length - 1;

        return maxCoinsHelper(newArr, start, end, dp);
    }

    private int maxCoinsHelper(int[] arr, int start, int end, int[][] dp) {
        //here we'll check all the possible order, and if the order
        //says 1, 3, 2, 4 then burst is happening as 4, 2, 3, 1

        if(start + 1 >= end) {
            //meaning start and end come together
            //no balloons left to burst
            return 0;
            //this is the max value we can get by doing this

        }

        if(dp[start][end] != -1) {
            return dp[start][end];
        }

        int ans = Integer.MIN_VALUE;
        for (int i = start + 1; i < end; i++) {
            //the index we're starting with should be burst last
            //hence to burst the current index, we first find the
            //ans after bursting from left side and ans after bursting
            //from right side, and then

            int leftAns = maxCoinsHelper(arr, start, i, dp);
            //as end points are exclusive, so we need ans till
            //left side of i index
            int rightAns = maxCoinsHelper(arr, i, end, dp);
            //start point is i itself as we've considered start point
            //also as exclusive, so we'll burst from i + 1 to end - 1

            int myAns = leftAns + rightAns + (arr[start] * arr[i] * arr[end]);
            //left burst + right burst + bursting the ith balloon
            //as jo additional ele add kare the woh edge case se prevent karne ke liye hi the
            //so we don't need to worry here about any case, just for every
            //case we write : arr[start] * arr[i] * arr[end]
            //and as all the balloons from ith index left side had been
            //bursted, so we only need to care to about the start
            //and as all the right ones are also bursted we only take
            //care about the end

            ans = Math.max(ans, myAns);
            //as this will check all the possible combinations, so we take the max
            //out of them
        }
        dp[start][end] = ans;
        return ans;
    }

    public int maxCoinsIterative(int[] nums) {
        int[] newArr = new int[nums.length + 2];
        newArr[0] = 1;
        newArr[nums.length + 1] = 1;
        //first and last index par dummy element bana diya 1 value
        //kaa, so as to help in edge cases

        for (int i = 1; i <= nums.length; i++) {
            newArr[i] = nums[i - 1];
        }

        int[][] dp = new int[newArr.length][newArr.length];

        //first we'll write the loop for gap
        for (int gap = 2; gap < newArr.length; gap++) {
            //last gap is b/w 0 and 5 : that is one less than
            //arr.length

            //for any specific gap, the start point
            //always starts with 0
            for (int start = 0; start < newArr.length - gap ; start++) {
                //and the last starting point will be
                //newArr.length - gap for each gap

                //now we know the start point and gap
                //so we can calculate end point now
                int endPoint = start + gap;
                //this is the loop for diagonal traversal

                int ans = Integer.MIN_VALUE;
                //now we start solving our problem here
                for (int i = start + 1; i < endPoint; i++) {
                    //this i will create the cut here
                    //start + 1 -> as hamaari original values
                    //are from start + 1 till endPoint - 1
                    int leftAns = dp[start][i];
                    int rightAns = dp[i][endPoint];

                    int myAns = leftAns + rightAns + newArr[start] * newArr[i] * newArr[endPoint];
                    ans = Math.max(ans, myAns);
                }
                dp[start][endPoint] = ans;
            }

        }
        return dp[0][newArr.length - 1];
    }

}
