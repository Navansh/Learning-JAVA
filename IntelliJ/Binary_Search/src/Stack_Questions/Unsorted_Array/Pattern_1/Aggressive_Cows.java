package Stack_Questions.Unsorted_Array.Pattern_1;

import java.util.Arrays;

public class Aggressive_Cows {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,5};
        System.out.println(solve(arr.length,4,arr));
    }

    public static int solve(int n, int k, int[] stalls) {
        //firstly find the min and max values for distance b/w the cows

        //array may be given unsorted, so sort it as our overall TC is anyways O(nlogn)
        Arrays.sort(stalls);
        int min = Integer.MAX_VALUE;
        int max = 0;
        int min_ele = stalls[0];
        int max_ele = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            min = Math.min(min,stalls[i] - stalls[i - 1]);
            //min is the minm distance b/w any 2 consecutive places in the array

            max_ele = Math.max(max_ele, stalls[i]);
            min_ele = Math.min(min_ele, stalls[i]);
        }

        int low = min;
        int high = max_ele - min_ele;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            //mid represents the minimum distance b/w 2 cows
            int cows_placed = cow_Calculator(stalls, mid);

            if(cows_placed >= k) {
                ans = mid;
                //now go to right, which means increase the distance b/w 2 cows
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private static int cow_Calculator(int[] stalls, int mid) {
        //stalls array needs to be sorted for our cow calculator function to work *****

        //mid is the minimum distance b/w 2 cows, now try to place the cows in the stalls
        int cows = 0;
        //placed the 1st cow on the 0th index
        cows++;
        int last_cow_placed_val = stalls[0];
        //we're always starting from 0

        //now we calculate for the second cow, as we've already placed cow#1 on 0th Index
        for (int i = 0; i < stalls.length; i++) {
            if(stalls[i] - last_cow_placed_val < mid) {
                continue;
            } else {
                //it means the distance is now greater than or equal to  mid
                cows++;
                //place the next cow here
                last_cow_placed_val = stalls[i];
            }
        }

        return cows;
        //no need to do cows + 1, as we've already accounted for it in the starting
    }
}
