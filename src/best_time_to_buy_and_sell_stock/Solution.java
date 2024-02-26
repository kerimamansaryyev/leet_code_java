package best_time_to_buy_and_sell_stock;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return  0;
        }
        int leastBuy = prices[0];
        int mostProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] <leastBuy){
                leastBuy = prices[i];
            }
            if(prices[i] - leastBuy > mostProfit){
                mostProfit = prices[i] - leastBuy;
            }
        }

        return mostProfit;
    }
}
