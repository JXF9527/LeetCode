package maximalSquare221;

public class Solution {
    /**
     * 暴力
     * @param matrix
     * @return
     */
    static public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int ans = 1;
        int i, j, m, n;
        int count;
        for (i = 0; i < matrix.length; i++) {
            T1:
            for (j = 0; j < matrix[0].length; j++) {
                count = ans * ans;
                //从[i][j]开始寻找长度为ans的正方形
                for (m = i; m < i + ans && m < matrix.length; ++m) {
                    for (n = j; n < j + ans && n < matrix[0].length; ++n) {

                        if (matrix[m][n] != '1')
                            continue T1;
                        else
                            --count;
                    }
                }
                //找到长度为ans的正方形，++ans后重新从该点找
                if (count == 0) {
                    --j;
                    ++ans;
                }
            }

        }

        return (ans - 1) * (ans - 1);
    }

    /*
     当我们判断以某个点为正方形右下角时最大的正方形时，那它的上方，左方和左上方三个点也一定是某个正方形的右下角，
     否则该点为右下角的正方形最大就是它自己了。这是定性的判断，那具体的最大正方形边长呢？我们知道，
     该点为右下角的正方形的最大边长，最多比它的上方，左方和左上方为右下角的正方形的边长多1，
     最好的情况是是它的上方，左方和左上方为右下角的正方形的大小都一样的，这样加上该点就可以构成一个更大的正方形。
     但如果它的上方，左方和左上方为右下角的正方形的大小不一样，合起来就会缺了某个角落，
     这时候只能取那三个正方形中最小的正方形的边长加1了。假设dpi表示以i,j为右下角的正方形的最大边长，
     则有 dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
     当然，如果这个点在原矩阵中本身就是0的话，那dp[i]肯定就是0了。
     */
    public int maximalSquare2(char[][] matrix) {
        /**
         dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长, 则递推式为:
         dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
         **/
        int m = matrix.length;
        if(m < 1)
            return 0;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max*max;
    }

    public static void main(String[] args) {
        maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'}
        ,{'1','1','1','1','1'},{'1','0','0','1','0'}});
    }
}
