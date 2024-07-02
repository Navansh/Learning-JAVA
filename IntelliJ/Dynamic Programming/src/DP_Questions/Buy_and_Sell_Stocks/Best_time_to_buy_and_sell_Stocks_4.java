package DP_Questions.Buy_and_Sell_Stocks;

public class Best_time_to_buy_and_sell_Stocks_4 {
    public static void main(String[] args) {
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
        //https://www.youtube.com/watch?v=3YILP-PdEJA
    }

    public int maxProfit(int k, int[] prices) {
        //O(n^3) sol
        int[][] dp = new int[k + 1][prices.length];

        //1st row se start kar rhe as 0th row toh poori 0 hi
        //hogi and same for 0th col, so day bhi 1 se start kar
        //rhe
        for (int txn = 1; txn <= k ; txn++) {
            for (int day = 1; day < prices.length; day++) {
                int max = dp[txn][day - 1];
                dp[txn][day] = dp[txn][day - 1];
                //this is the by default value, which means
                //we haven't done any txn today
                //hence continuing with the prev day profit
                //and the no of txns required by the question are done
                //if using this value
                //now we're seeing if we can beat this, by increasing
                //number of days

                //now we calculate, if we can do txn, that how
                //much profit we can earn
                //we'll iterate through the prev day
                //day - 1 and txn - 1 ki poori
                //row se iterate karenge
                for (int pastDay = 0; pastDay < day; pastDay++) {
                    //hence prev day tak jaayenge for (txn - 1) row
                    int profitTillTMinusOneTxn = dp[txn - 1][pastDay];
                    int profitFromTodaysTxn = prices[day] - prices[pastDay];

                    if(profitTillTMinusOneTxn + profitFromTodaysTxn > max) {
                        //max here represents the default value
                        //meaning no txn, just continue with prev day profit
                        //and already 3 txn have happened when using the max's value
                        max = profitTillTMinusOneTxn + profitFromTodaysTxn;
                    }

                    dp[txn][day] = max;
                }
            }
        }

        return dp[k][prices.length - 1];
    }

    public int maxProfitOptimized(int k, int[] prices) {
        //O(n^2) sol
        int[][] dp = new int[k + 1][prices.length];

        for (int txn = 1; txn <= k ; txn++) {
            int max = Integer.MIN_VALUE;
            //means ek row pehle ka 1st cell or 0th col
            //as wohi se toh max build karna start karenge
            for (int day = 1; day < prices.length; day++) {
                if(dp[txn - 1][day - 1] - prices[day - 1] > max) {
                    //exactly as written in the copy
                    max = dp[txn - 1][day - 1] - prices[day - 1];
                }

                if(max + prices[day] > dp[txn][day - 1]) {
                    //this is our last competition
                    //jo ki straightforward ek din pehle hai
                    //and with the same no of txns
                    dp[txn][day] = max + prices[day];
                    //as max toh sirf difference store kar rha
                    //as written in copy toh usmein price
                    //add karna padega
                } else {
                    dp[txn][day] = dp[txn][day - 1];
                }

            }
        }

        return dp[k][prices.length - 1];

    }


}
