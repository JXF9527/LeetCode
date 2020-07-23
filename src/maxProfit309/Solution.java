package maxProfit309;

public class Solution {
    /**
     * dp，分三种状态，dp[i][0]是第i天不持股的最大利润，dp[i][1]是持股，dp[i][2]是冷冻期
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; ++i) {
            //第i天不持股，则第i - 1天不持股或是冷冻期
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            //第i天持股，则第i - 1天不持股第i天买入或之前就持股
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            //第i天进入冷冻期，则前一天持股今天卖出
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        //最终答案在不持股状态和冷冻期状态中选出
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }


}
