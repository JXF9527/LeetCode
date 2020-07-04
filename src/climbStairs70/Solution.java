package climbStairs70;

public class Solution {
    /**
     * 递归，超时
     * @param n
     * @return
     */
    static public int climbStairs(int n) {
        if(n == 0)
            return 1;
        else if(n < 0)
            return 0;
        else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    /**
     * 组合数，失败
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if(n <= 1)
            return 1;
        int num = n / 2;
        int cnum;
        int ans = 0;
        for (int i = 0; i <= num; ++i){
            cnum = n - i;
            ans += C(cnum, i);
        }
        return ans;
    }

    /**
     * dp，Fibo数列
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if(n <= 2)
            return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n; ++i){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //求排列数 A(n,m) n>m
    public static int A(int n, int m)
    {
        int result = 1;
        for (int i = m; i > 0; i--)
        {
            result *= n;
            --n;
        }
        return result;
    }

    public static int C(int n, int m)// 应用组合数的互补率简化计算量
    {
        int helf = n / 2;
        if (m > helf)
        {
            m = n - m;
        }
        // 分子的排列数
        int numerator = A(n, m);
        // 分母的排列数
        int denominator = A(m, m);
        return numerator / denominator;
    }

    public static void main(String[] args){
        System.out.println(climbStairs(7));

    }
}
