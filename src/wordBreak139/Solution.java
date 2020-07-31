package wordBreak139;

import java.util.*;

public class Solution {
    /**
     * 以正则表达式(单词|单词……)*匹配
     * @param s
     * @param wordDict
     * @return
     */
    static public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0)
            return false;
        StringBuffer buf = new StringBuffer();
        buf.append("(");
        Iterator<String> it = wordDict.iterator();
        while (it.hasNext()) {
            buf.append(it.next());
            buf.append("|");
        }
        buf.deleteCharAt(buf.length() - 1);
        buf.append(")*");
        return s.matches(buf.toString());
    }


    public static void main(String[] args) {
        ;
    }
}
