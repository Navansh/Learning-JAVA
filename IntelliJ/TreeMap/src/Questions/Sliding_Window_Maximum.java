package Questions;

import java.util.*;

public class Sliding_Window_Maximum {
    public static void main(String[] args) {
        //https://leetcode.com/problems/sliding-window-maximum/
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(maxSlidingWindow(nums,4));
    }

    public static int[] maxSlidingWindowOptimized(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        //these are number of subarrays so possible
        int counter = 0;

        //solve for the first k elements firstly
        //hence forming the 1st window
        //but in dq we add only the req elements
        for (int i = 0; i < k; i++) {
            while (dq.size() > 0 && dq.getLast() < nums[i]) {
                //when the last condition happens only then we remove
                //then that last element can never be the ans so remove it
                //from dq
                dq.removeLast();
            }

            dq.addLast(nums[i]);
        }

        //add the ans for the first window
        //as uske baad ki saari windows ke liye hum next loop run karenge
        ans[counter++] = dq.getFirst();

        //now we've processed from 0 to (k - 1)th index
        //now we'll start with the window from index k

        for (int i = k; i < nums.length; i++) {

            //here also check to remove the element which was previously present
            //as max in the queue and is now out of our window(hence not max now)
            //so our window here if from ((i - k + 1) to to i)

            while (dq.size() > 0 && dq.getLast() < nums[i]) {
                //when the last condition happens only then we remove
                //then that last element can never be the ans so remove it
                //from dq
                dq.removeLast();
            }

            dq.addLast(nums[i]);

            if(dq.getFirst() == nums[i - k]) {
                dq.removeFirst();
            }
            //if this is not the case, then that value has already been removed using
            //the above condition

            ans[counter++] = dq.getFirst();
        }


        return ans;

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int counter = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //iterate and add the first k integers to the priority queue
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        ans[counter++] = pq.peek();

        for (int i = k; i < nums.length; i++) {
            //add new element, remove the i - kth element from the list and add the ans
            pq.remove(nums[i - k]);
            pq.add(nums[i]);
            ans[counter++] = pq.peek();
        }

        return ans;
    }
}
