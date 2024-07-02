package DP_Questions.Buy_and_Sell_Stocks;

public class Best_time_to_buy_and_sell_stock_with_Cooldown {
    public static void main(String[] args) {
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/submissions/1303555789/
    }

    public int maxProfit(int[] prices) {
        int buy = -prices[0];
        int sell = 0;
        int cooldown = 0;

        for (int i = 1; i < prices.length; i++) {
            int newBuy = Math.max(buy, cooldown - prices[i]);
            int newSell = Math.max(sell, prices[i] + buy);
            //adding buy as that is negative
            cooldown = Math.max(sell, cooldown);

            //update the values to be used for next txn
            buy = newBuy;
            sell = newSell;
        }

        return sell;
    }
}
