package minWindow76;

import java.util.*;

public class Solution {
    /**
     * 滑动窗口
     * @param s
     * @param t
     * @return
     */
    static public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.length() == 0)
            return "";
        Map<Character, Integer> map = new HashMap<>();
        int i;
        char[] sa = s.toCharArray();
        char[] st = t.toCharArray();
        int start = 0;
        int left = 0, right = 0;
        int count = 0;
        int ans = Integer.MAX_VALUE;
        for (i = 0; i < st.length; i++) {
            map.put(st[i], map.getOrDefault(st[i], 0) + 1);
        }

        Map<Character, Integer> windows = new HashMap<>();
        while (right < sa.length) {
            if (map.containsKey(sa[right])) {
                windows.put(sa[right], windows.getOrDefault(sa[right], 0) + 1);
                if (windows.get(sa[right]).intValue() == map.get(sa[right]).intValue())
                    ++count;
            }

            ++right;
            //已经找到子串时，尝试缩小区间
            while (count == map.size()) {
                if (right - left < ans) {
                    start = left;
                    ans = right - left;
                }

                if (map.containsKey(sa[left])) {
                    windows.put(sa[left], windows.getOrDefault(sa[left], 0) - 1);
                    if (map.get(sa[left]).intValue() > windows.get(sa[left]).intValue())
                        --count;
                }

                ++left;
            }
        }

        return ans == Integer.MAX_VALUE ? "" : s.substring(start, start + ans);
    }

    public static void main(String[] args) {
        minWindow("aa", "aa");
    }
}
