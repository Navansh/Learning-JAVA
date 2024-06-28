package DP_Questions.Buy_and_Sell_Stocks;

public class Best_time_to_buy_and_sell_stocks_with_Transaction_fees {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices, int fee) {
        //transaction fee is applied on every txn,
        //a txn is complete buy and sell combined
        int prevBestBuyPrice = -prices[0];
        //as this is the net profit after buying, so
        //negative hogaa
        int sellProfit = 0;
        //it will be 0 or positive
        //meaning abhi khareeda and abhi bech diya

        for (int i = 1; i < prices.length; i++) {
            int currentBuy = Math.max(prevBestBuyPrice, sellProfit - prices[i]);
            //getting the better one from : last time bought price net profit (being continued now )
            //or the sell karne ke baad aaj buy karta hoon toh
            int currentSell = Math.max(sellProfit, prices[i] + prevBestBuyPrice - fee);
            //best one is we just continue with the prev sell profit or we sell it now
            //and get the margin between prevBestbuy Price and current price
            //and also deducting fee from it

            prevBestBuyPrice = currentBuy;
            sellProfit = currentSell;
        }

        return sellProfit;
    }
}
