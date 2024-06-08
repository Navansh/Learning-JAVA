import java.util.Arrays;

public class n_Stairs {
    public static void main(String[] args) {

    }

    public static int Stairs(int num) {
       int[] dp = new int[num + 1];
        Arrays.fill(dp, -1);
       return stairSolver(num, dp);
        //this is considering that we give num as 5 and then decrease down there
//        hence we calculate the ways to fo from n to 0 which is same as going 0 to n
        //in this problem context***
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(0, n, dp);
        //this is considering that we give num as 0 and then increase from there
        //till we reach n
    }

    private int solve(int i, int n, int[] dp) {
        if (i == n) return 1;
        if (i > n) return 0;

        if (dp[i] != -1) return dp[i];

        dp[i] = solve(i + 1, n, dp) + solve(i + 2, n, dp);

        return dp[i];
    }


    private static int stairSolver(int num, int[] dp) {

        if(num == 1 || num == 2) {
            return num;
        }

        if(dp[num] != -1) {
            return dp[num];
        }

        int ways = stairSolver(num - 1, dp) + stairSolver(num - 2, dp);
        dp[num] = ways;
        return ways;
    }
}
