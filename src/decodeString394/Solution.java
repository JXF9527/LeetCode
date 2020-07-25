package decodeString394;

import java.util.*;


public class Solution {
    /**
     * 栈实现
     * @param s
     * @return
     */
    public String decodeString(String s) {
        List<Character> slist = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        StringBuffer buf = new StringBuffer();
        int num;
        for (char c : s.toCharArray()) {
            if (c == ']') {
                //寻找 [
                while (!stack.peek().equals('[')) {
                    slist.add(0, stack.pop());
                }
                // [ 退栈
                stack.pop();
                //判断重复次数
                while (!stack.empty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    buf.insert(0, stack.pop());
                }
                num = Integer.valueOf(buf.toString());
                buf.delete(0, buf.length());

                while (num-- > 0) {
                    Iterator<Character> it = slist.iterator();
                    while (it.hasNext()) {
                        stack.push(it.next());
                    }
                }
                slist.clear();
            }
            else {
                stack.push(c);
            }
        }
        //最终答案为去除多余字符的串
        return stack.toString().replaceAll("[,\\]\\[\\s]", "");
    }
}
