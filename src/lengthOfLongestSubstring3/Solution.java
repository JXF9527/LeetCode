package lengthOfLongestSubstring3;

import java.util.*;

public class Solution {


    /*
     * 遍历，遇到重复字符则退出该字符之前的串，记录最大长度
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0, right = 0;
        char[] array = s.toCharArray();
        int i, j;
        for (i = 0; i < array.length; ++i) {
            char c = array[i];
            if (!set.contains(c)) {
                set.add(c);
                max = max > set.size() ? max : set.size();
            }
            else {
                for (j = left; array[j] != c; ++j) {
                    set.remove(array[j]);
                }
                left = j + 1;
            }
        }

        return max;
    }
}
