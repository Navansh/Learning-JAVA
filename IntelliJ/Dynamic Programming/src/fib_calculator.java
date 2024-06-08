import java.util.Arrays;

public class fib_calculator {
//    int[] arr = new int[]
    public static void main(String[] args) {

    }

    public static int fibCalculator(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        //this will fill the array, with -1 val on all indices
        //internally it just applies a loop and fills all indices
        return fibHelper(n ,dp);
    }

    private static int fibHelper(int n, int[] dp) {
        if(n == 0 || n == 1) {
            return n;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        int ans1 = fibHelper(n-1,dp);
        int ans2 = fibHelper(n-2, dp);

        dp[n] = ans1 + ans2;
        return ans1 + ans2;
    }
}
