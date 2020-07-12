package numTrees96;

public class Solution {

    /**
     * dp，顺序相同，数量相同的数列二叉树个数相同
     * @param n
     * @return
     */
    static public int numTrees(int n) {
        if(n <= 2)
            return n;
        int[] dp = new int[n + 1];
        int j;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            //分别以1~i为根，计算左右子树组合个数
            for (j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        numTrees(3);
    }
}
