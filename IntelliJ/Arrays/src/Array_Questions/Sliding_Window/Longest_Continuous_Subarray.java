package Array_Questions.Sliding_Window;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Longest_Continuous_Subarray {
    //w absolute difference less than or equal to limit
    public static void main(String[] args) {

    }

    class Pair implements Comparable<Pair> {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }


        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }

    public int longestSubarray(int[] nums, int limit) {
        //koi bhi subarray ko agar valid pata karna hai
        //then check if the difference between its highest and
        //the lowest ele is within the limit
        //if yes, then all elements difference will be within limit

        PriorityQueue<Pair> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        //this will create maxHeap
        PriorityQueue<Pair> minPQ = new PriorityQueue<Pair>();

        //now while traversing through the nums array we'll keep filling
        //the max and min heap, so as to keep track
        //of the highest and smallest number in the range (subarray)
        //and if a certain index violates that, we just cut through
        //our subarray till that index, hence shrink our window
        //and delete those elements from the PQs

        int maxLen = 0;

        //to maintain window we'll use i and j pointer
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            Pair temp = new Pair(nums[j], j);
            maxPQ.add(temp);
            minPQ.add(temp);

            //now shrink till the window becomes valid
            while (maxPQ.peek().val - minPQ.peek().val > limit) {
                //now shrink the window
                i = Math.min(maxPQ.peek().idx, minPQ.peek().idx) + 1;

                while (maxPQ.peek().idx < i) {
                    maxPQ.remove();
                }

                while (minPQ.peek().idx < i) {
                    minPQ.remove();
                }
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;

    }
}
