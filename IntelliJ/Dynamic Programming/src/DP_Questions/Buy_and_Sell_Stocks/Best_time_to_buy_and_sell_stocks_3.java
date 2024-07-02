package DP_Questions.Buy_and_Sell_Stocks;

public class Best_time_to_buy_and_sell_stocks_3 {
    public static void main(String[] args) {
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    }

    public static int maxProfit(int[] prices) {
        //first find the leftMaxProf
        int[] leftMaxProf = new int[prices.length];
        int[] rightMaxProf = new int[prices.length];

        int minBuyPrice = prices[0];
        int maxSellPrice = prices[prices.length - 1];
        int maxProfitLeft = 0;
        int maxProfitRight = 0;

        for (int i = 0; i < prices.length; i++) { //O(N)
            if(prices[i] < minBuyPrice) {
                minBuyPrice = prices[i];
            }

            int currentProf = prices[i] - minBuyPrice;
            leftMaxProf[i] = Math.max(currentProf, maxProfitLeft);
            maxProfitLeft = Math.max(maxProfitLeft, currentProf);
        }

        for (int i = prices.length - 1; i >= 0; i--) { //O(N)
            if(prices[i] > maxSellPrice) {
                maxSellPrice = prices[i];
            }

            int currentProf = maxSellPrice - prices[i];
            rightMaxProf[i] = Math.max(currentProf, maxProfitRight);
            maxProfitRight = Math.max(maxProfitRight, currentProf);
        }

        //now check using both vars
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) { //O(N)
            maxProfit = Math.max(leftMaxProf[i] + rightMaxProf[i], maxProfit);
        }

        return maxProfit;
    }
}
