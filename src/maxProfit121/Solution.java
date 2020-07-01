package maxProfit121;

public class Solution {
    /**
     * O(n^2)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0; i < prices.length; ++i){
            for(int j = i + 1; j < prices.length; ++j){
                if(prices[j] > prices[i]){
                    int sub = prices[j] - prices[i];
                    if(sub > max)
                        max = sub;
                }
            }
        }
        return max;
    }

    /**
     * DP
     * 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int max = 0;
        int minPrice = prices[0];
        for(int i = 1; i < prices.length; ++i){
            int sub = prices[i] - minPrice;
            max = max > sub ? max : sub;
            if(sub < 0)
                minPrice = prices[i];
        }
        return max;
    }
}
