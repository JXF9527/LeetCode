package letterCombinations17;

import java.util.*;

public class Solution {
    static private String[] str = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 回溯法
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return ans;
        backTrack(digits, 0, "", ans);
        return ans;
    }

    private void backTrack(String digits, int j, String now, List<String> ans) {
        if (now.length() == digits.length()) {
            ans.add(now);
            return;
        }

        String values = str[digits.charAt(j) -'2'];
        for (char c : values.toCharArray()) {
            backTrack(digits, j + 1, now + c, ans);
        }
    }
}
