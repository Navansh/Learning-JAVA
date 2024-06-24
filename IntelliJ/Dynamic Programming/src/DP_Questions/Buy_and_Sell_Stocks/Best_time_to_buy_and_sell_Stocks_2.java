package DP_Questions.Buy_and_Sell_Stocks;

public class Best_time_to_buy_and_sell_Stocks_2 {
    public static void main(String[] args) {
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    }

    public int maxProfit(int[] prices) {
        //just capture the upward trajectory waale stocks
        int ans = 0;
        //min profit is 0, buy and sell the same stock
        //on the same day
        int prev = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prev) {
                //capture this
                int diff = prices[i] - prev;
                ans += diff;
            }

            prev = prices[i];
        }

        return ans;
    }
}
