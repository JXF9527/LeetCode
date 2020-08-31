package removeInvalidParentheses301;

import java.util.*;

public class Solution {
    private int max = 0;
    /**
     * 回溯，找长度最长，也就是删除最少的串
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        Set<String> ans = new HashSet<>();
        backTrack(ans, s.toCharArray(), new StringBuffer(), 0, 0, 0);
        return new ArrayList<>(ans);
    }

    private void backTrack(Set<String> ans, char[] s, StringBuffer buffer, int left, int right, int depth) {
        if (depth == s.length) {

            if (left != right)
                return;

            if (buffer.length() < max)
                return;

            //如果存在超过max的串，则删除原有ans
            if (buffer.length() > max) {
                max = buffer.length();
                ans.clear();
            }
            ans.add(buffer.toString());
            return;
        }

        if (right > left)
            return;

        switch (s[depth]) {
            case '(':
                buffer.append(s[depth]);
                backTrack(ans, s, buffer, left + 1, right, depth + 1);
                buffer.deleteCharAt(buffer.length() - 1);
                break;
            case ')':
                buffer.append(s[depth]);
                backTrack(ans, s, buffer, left, right + 1, depth + 1);
                buffer.deleteCharAt(buffer.length() - 1);
                break;
            default:
                buffer.append(s[depth]);
                backTrack(ans, s, buffer, left, right, depth + 1);
                buffer.deleteCharAt(buffer.length() - 1);
                return;
        }

        //不选字符加入
        backTrack(ans, s, buffer, left, right, depth + 1);
    }
}
