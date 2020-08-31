package maxCoins312;

import java.util.Arrays;
import java.util.Map;

public class Solution {
    /**
     * 以两个数作为左右端点，找出最优解中它们中间那个戳破的气球，中间这个气球把整个队列分为了2部分，
     * 要想让中间这个气球和2个端点靠在一起，就需要先把分开的2部分的气球戳破。
     * dp[i][j]表示i~j最大值，i，j不戳破。 比如k气球在i,j之间时(i,k,j)被戳破，
     * 那么要先戳破i,k、k,j之间的气球，所以dp[i][j]=dp[i][k]+dp[k][j]+nums[i]*nums[k]*nums[j]
     * @param nums
     * @return
     */
    static public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        int[] newnums = new int[nums.length + 2];
        newnums[0] = 1;
        newnums[newnums.length - 1] = 1;
        int i, j, k;

        for (i = 1; i <= nums.length; ++i) {
            newnums[i] = nums[i - 1];
        }

        for (i = nums.length - 1; i >= 0; --i) {
            for (j = i + 2; j < nums.length + 2; ++j) {
                for (k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + newnums[i]*newnums[k]*newnums[j]);
                }
            }
        }

        return dp[0][nums.length + 1];
    }

    public static void main(String[] args) {
        maxCoins(new int[]{3,1,5,8});
    }
}
