package DP_Questions.LIS;

import java.util.Arrays;

public class Building_Bridges {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
    }

    class Pair implements Comparable<Pair> {
        //when we need to sort pair class we need to implement
        //Comparable<Pair>
        int x;
        int y;

        @Override
        public int compareTo(Pair o) {
            if(this.x - o.x != 0) {
                //this will sort on the basis of width in increasing order
                //only if they are not equal
                return this.x - o.x;
            } else {
                //f they are equal then sort on basis of height
                //and in decreasing order
                return o.y - this.y;
            }
        }

        Pair(int w, int h) {
            this.x = w;
            this.y = h;
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

        //now apply LIS on y of sorted array arr
        int[] dp = new int[arr.length];
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            int lo = 0;
            int hi = ans;

            while (lo < hi) {
                int mid = lo + (hi - lo)/2;

                if(dp[mid] < arr[i].y) {
                    //as doing based on height
                    lo = mid + 1;
                } else {
                    //dp[mid] >= envelopes[i][1]
                    hi = mid;
                }
            }

            dp[lo] = arr[i].y;

            if(lo == ans) {
                ans++;
            }
        }

        return ans;
    }
}
