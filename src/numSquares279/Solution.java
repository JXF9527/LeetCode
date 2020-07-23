package numSquares279;

import java.util.*;

public class Solution {
    private int min;
    /**
     * 回溯法
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] squares = new int[(int)Math.sqrt(n)];
        for (int i = 0; i < squares.length; ++i) {
            squares[squares.length - 1 - i] = (i + 1) * (i + 1);
        }
        if (squares[0] == n)
            return 1;
        min = 4;
        backTrack(squares, n, 0, 0);
        return min;
    }

    private void backTrack(int[] squares, int n, int j, int count) {

        if (n < 0)
            return;
        else if (n == 0) {
            min = min < count ? min : count;
            return;
        }

        if (count >= min)
            return;

        for (int i = j; i < squares.length; ++i) {
            backTrack(squares, n - squares[i], i,count + 1);
            if (count >= min)
                break;
        }
    }

    /**
     * dp
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        int i, j;
        Arrays.fill(dp, n);
        dp[0] = 0;
        dp[1] = 1;
        for (i = 1; i <= n; ++i) {
            for (j = 1; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j*j]);
            }
        }
        return dp[n];
    }
}
