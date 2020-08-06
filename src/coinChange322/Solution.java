package coinChange322;

import java.util.*;

public class Solution {
    /**
     * dp[i]表示金额为i所需的硬币最小个数
     * @param coins
     * @param amount
     * @return
     */
    static public int coinChange(int[] coins, int amount) {
        if (coins.length == 0)
            return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int j = 1; j <= amount; j++) {
            for (int i = 0; i < coins.length; i++) {
                if (j - coins[i] >= 0 && j - coins[i] <= amount) {
                    if (dp[j] == -1) {
                        if (dp[j - coins[i]] != -1)
                            dp[j] = dp[j - coins[i]] + 1;

                    }
                    else {
                        if (dp[j - coins[i]] != -1)
                            dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                    }
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        coinChange(new int[]{1,2,5},11);
    }
}
