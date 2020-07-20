package uniquePaths62;

import java.util.*;

public class Solution {
    /**
     * dp
     * @param m
     * @param n
     * @return
     */
    static public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        int i, j;
        Arrays.fill(dp[0], 1);
        for (i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        for (i = 1; i < m; ++i) {
            for (j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 排列组合，从m + n - 2步中选m - 1步向右或 n - 1步向下，C(m + n - 2, m - 1)
     * @param m
     * @param n
     * @return
     */
    static public int uniquePaths2(int m, int n) {
        return 0;
    }

    public static void main(String[] args) {

    }
}
