package longestPalindrome5;

public class Solution {
    /**
     * 中心扩散法
     * @param s
     * @return
     */
    static public String longestPalindrome(String s) {
        char[] carray = s.toCharArray();
        StringBuffer tmp = new StringBuffer();
        String ans = "";
        int l, r;
        for (int i = 0; i < carray.length; i++) {
            //奇数串
            l = i;
            r = i;

            while (l >= 0 && r < carray.length && carray[l] == carray[r]) {
                --l;
                ++r;
            }
            if (l == i && r == i) {
                --l;
                ++r;
            }
            if (r - l - 1 > ans.length())
                ans = s.substring(l + 1, r);

            //偶数串

            l = i;
            r = i + 1;
            while (l >= 0 && r < carray.length && carray[l] == carray[r]) {
                --l;
                ++r;
            }
            if (l == i && r == i + 1) {
                //nothing to do
            }
            else {
                if (r - l - 1 > ans.length())
                    ans = s.substring(l + 1, r);
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        longestPalindrome("a");
    }
}
