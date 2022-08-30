public class Prob_1672_arrays_easy_Leetcode
{
//    https://leetcode.com/problems/richest-customer-wealth/
    public static void main(String[] args) {
        int[][] arr = {{1,5},{7,3},{3,5}};
        int max = maximumWealth(arr);
        System.out.println(max);
    }

    private static int maximumWealth(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum = sum+arr[i][j];
            }
            if (sum>max)
            {
                max =sum;
            }
        }


        return max;
    }
}
