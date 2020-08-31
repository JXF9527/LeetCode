package longestValidParentheses32;

import java.util.*;

public class Solution {
    private int max = 0;
    /**
     * 遍历一遍
     * @param s
     * @return
     */
    static public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> intstack = new Stack<>();
        char[] sarray = s.toCharArray();
        boolean[] ans = new boolean[sarray.length];
        int max = 0;
        int count = 0;
        int i;
        for (i = 0; i < sarray.length; i++) {
            if (sarray[i] == ')' && !stack.empty()) {
                if (stack.peek().charValue() == '(') {
                    stack.pop();
                    ans[i] = true;
                    ans[intstack.pop()] = true;
                    continue;
                }
            }

            intstack.push(i);
            stack.push(sarray[i]);

        }

        for (i = 0; i < ans.length; i++) {
            if (ans[i])
                ++count;
            else {
                max = max > count ? max : count;
                count = 0;
            }
        }

        max = max > count ? max : count;

        return max;
    }


    public static void main(String[] args) {
        longestValidParentheses("(()");
    }


}
