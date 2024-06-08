package Array_Questions.Two_Pointers;

import java.util.Arrays;

public class Pair_Given_Difference {
    public static void main(String[] args) {
        int[] arr = {8182,8847,9438,1292,2782,7715,6984,7173,2768,776,2762,2248,692,9622,5814,6978,3073,6849,3363,8582,2924,7136,8285,2402,1625,7966,6811,4169,4542,2327,9887,9075,7525,5677,6718,307,3391,3701,7479,6158,4477,6593,4757,1520,6214,6922,8497,5638,3770,8211,4219,3045,1698,8856,5447,3322,6821,8609,7491,1362,7287,3729,6788,4812,9405,3505,1470,9147,7206,5300,5304,8034,1892,6412,9553,4457,3334,4402,6446,7103,8964,7017,148,662,5872,1946,3983,2692,554,7825,405,7840,1554,7192,9003,7310,7048,472,6457,4253,5772,8112,8638,4015,876,4543,4824,4209,8944,1269,7663,4259,8285,4162,4920,508,6107,8903,3199,6660,3079,9955,852,4632,7146,9854,8294,546,6678,1102,1150,2449,5565,9788,2815,6440,4330,7638,648,9625,5259,4663,3883,9895,8824,5155,403,4931,4057,9953,7942,7135,9908,8793,8119,3405,4999,2764,3950,1676,3865,5100,476,5781,1239};
        System.out.println(findPair(arr, arr.length, 219));
        //https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1
    }

    public static boolean findPair(int arr[], int size, int n)
    {
        //code here.
        //firstly sort the array
        Arrays.sort(arr);
        //we need to find pair whose difference is positive n

        int i = 0;
        int j = 1;

        while(i < arr.length && j < arr.length) {
            if(i != j && arr[j] - arr[i] == n) {
                return true;
            } else if(arr[j] - arr[i] > n) {
                i++;
            } else {
                j++;
            }
        }

        return false;
    }
}
