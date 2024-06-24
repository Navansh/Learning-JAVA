package DP_Questions.Buy_and_Sell_Stocks;

public class Best_time_to_buy_and_Sell_Stocks {
    public static void main(String[] args) {
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        int minBP = prices[0];

        for (int i = 1; i < prices.length; i++) {
            //1 se start kar rhe as 0th day buy karke sell
            //nhi kar sakte
            //firstly update the minBP
            minBP = Math.min(minBP, prices[i - 1]);
            //kinda like prefixMin

            int pL = prices[i] - minBP;
            ans = Math.max(ans, pL);
        }

        return ans;
    }
}
