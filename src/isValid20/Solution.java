package isValid20;

import java.util.*;

public class Solution {
    /**
     * 栈实现
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char c;
        for (int i = 0; i < s.length(); ++i) {
            c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(!stack.empty() && stack.peek().equals('(')) {
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                    break;
                case ']':
                    if(!stack.empty() && stack.peek().equals('[')) {
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                    break;
                case '}':
                    if(!stack.empty() && stack.peek().equals('{')) {
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                    break;
            }
        }
        return stack.empty();
    }

    /**
     * replace方法
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        int i = s.length() / 2;
        while (i-- > 0) {
            s = s.replace("()","").replace("[]","").replace("{}","");
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([])";
        System.out.println(s.replace("()","").replace("[]","").replace("{}",""));
    }
}
