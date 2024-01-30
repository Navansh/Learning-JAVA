package Questions;

import java.util.ArrayList;
import java.util.Arrays;

public class Perfect_Squares {
    public static void main(String[] args) {
//       Given an integer n, return the least number of perfect square numbers that sum to n.
//        System.out.println(perfectSquaresWithoutDP(556));
//        System.out.println(perfectSquaresWithDP(556));
        System.out.println(printAllPerfectSquares(6));
    }

    public static int perfectSquaresWithoutDP(int num) {

        if(num==0 || num == 1) {
            return num;
        }

        int smallest = Integer.MAX_VALUE;
        //smallest here represents the smallest number of ways we can reach n
        // with perfect squares
        for (int i = 1; i * i <= num ; i++) {
            //this is beacuse there are variable num of call, for each num
            //depending upon the choices we have for the number of perfect
            //square number present less than equal to num
            int temp = perfectSquaresWithoutDP((num - i*i));
            smallest = Math.min(smallest, temp);
        }

        return smallest + 1;

    }

    public static int perfectSquaresWithDP(int num) {
        int[] dp = new int[num + 1];
        Arrays.fill(dp, -1);
        return dpHelper(num, dp);
    }

    private static int dpHelper(int num, int[] dp) {
        if(num==0 || num == 1) {
            return num;
        }

        if(dp[num] != -1) {
            return dp[num];
        }
        int smallest = Integer.MAX_VALUE;
        //smallest here represents the smallest number of ways we can reach n
        // with perfect squares
        for (int i = 1; i * i <= num ; i++) {
            //this is beacuse there are variable num of call, for each num
            //depending upon the choices we have for the number of perfect
            //square number present less than equal to num
            int temp = dpHelper((num - i*i), dp);
            smallest = Math.min(smallest, temp);
        }

        dp[num] = smallest + 1;
        return smallest + 1;
    }

    public static ArrayList<Integer> printAllPerfectSquares(int num) {
        //print all the perfect squares for the sum
        ArrayList<Integer> listerr = new ArrayList<>();
        int[] dp = new int[num + 1];
        Arrays.fill(dp, -1);
        helperArralst(listerr,dp, num );
        return listerr;
    }

    private static int helperArralst(ArrayList<Integer> listerr, int[] dp, int num) {
        if(num==0 || num == 1) {
            return num;
        }

        if(dp[num] != -1) {
            return dp[num];
        }
        int smallest = Integer.MAX_VALUE;
        int index = 0;
        //smallest here represents the smallest number of ways we can reach n
        // with perfect squares
        for (int i = 1; i * i <= num ; i++) {
            //this is beacuse there are variable num of call, for each num
            //depending upon the choices we have for the number of perfect
            //square number present less than equal to num
            int beforeSmaller = smallest;
            int temp = helperArralst(listerr,dp,(num - i*i));
            smallest = Math.min(smallest, temp);
            if(beforeSmaller != smallest) {
                //then this is the ans still
                listerr.add(-1);
                listerr.set(index, i * i);
            }
        }

        dp[num] = smallest + 1;
        index++;
        return smallest + 1;
    }
}
