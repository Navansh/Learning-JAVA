package DP_Questions.LIS;

import java.util.Arrays;

public class Building_Bridges {
    public static void main(String[] args) {

    }

    class Pair implements Comparable<Pair> {
        //when we need to sort pair class we need to implement
        //Comparable<Pair>
        int w;
        int h;

        @Override
        public int compareTo(Pair o) {
            if(this.w - o.w != 0) {
                //this will sort on the basis of width in increasing order
                //only if they are not equal
                return this.w - o.w;
            } else {
                //f they are equal then sort on basis of height
                //and in decreasing order
                return o.h - this.h;
            }
        }

        Pair(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }

    public int non_overlapping_bridges(int[][] coords, int n) {
        //same as Russian Doll Envelope
        //2d array with no of cols = 2
        Pair[] arr = new Pair[coords.length];

        for (int i = 0; i < coords.length; i++) {
            arr[i] = new Pair(coords[i][0], coords[i][1]);
        }

        Arrays.sort(arr);
        //hence we've sorted it according to the compare function
        //condition written above
        //i.e. based on width and then based on height

        //now apply LIS on height of sorted array arr
        int[] dp = new int[arr.length];
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            int lo = 0;
            int hi = ans;

            while (lo < hi) {
                int mid = lo + (hi - lo)/2;

                if(dp[mid] < arr[i].h) {
                    //as doing based on height
                    lo = mid + 1;
                } else {
                    //dp[mid] >= envelopes[i][1]
                    hi = mid;
                }
            }

            dp[lo] = arr[i].h;

            if(lo == ans) {
                ans++;
            }
        }

        return ans;
    }
}
