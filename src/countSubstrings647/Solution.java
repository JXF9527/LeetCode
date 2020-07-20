package countSubstrings647;

public class Solution {
    /**
     * 暴力
     * @param s
     * @return
     */
    static public int countSubstrings(String s) {
        int ans = s.length();
        for (int i = 2; i <= s.length(); ++i) {
            for (int j = 0; j <= s.length() - i; ++j) {
                if (isPal(s.substring(j, j + i)))
                    ++ans;
            }
        }
        return ans;
    }

    static private boolean isPal(String str) {
        for (int i = 0; i < str.length() / 2; ++i) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }

    /**
     * 中心扩展法，分奇数和偶数回文子串
     * @param s
     * @return
     */
    public int countSubstrings2(String s) {
        int ans = 0;
        int l, r;
        for (int i = 0; i < s.length(); ++i) {
            //奇数
            l = i;
            r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                ++ans;
                --l;
                ++r;
            }

            //偶数
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                ++ans;
                --l;
                ++r;
            }
        }

        return ans;
    }

    /**
     * dp[j] = 1，表示当前位置到j之间形成回文
     * @param s
     * @return
     */
    public int countSubstrings3(String s) {
        int ans = 0;
        int i;
        int[] dp = new int[s.length()];

        for (i = 0; i < s.length(); ++i) {
            dp[i] = 1;
            ++ans;
            for (int j = 0; j < i; ++j) {
                if (s.charAt(i) == s.charAt(j) && dp[j + 1] == 1) {
                    ++ans;
                    dp[j] = 1;
                }
                else
                    dp[j] = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        countSubstrings("abcdef");
    }
}
