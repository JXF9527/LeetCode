package generateParenthesis22;

import java.util.*;

public class Solution {
    /**
     * 递归，dfs+剪枝
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, "", 0, 0, n);
        return ans;
    }

    private void dfs(List<String> ans ,String buffer, int lnum, int rnum, int n) {
        if(lnum > n || rnum > n) {
            return;
        }
        if(lnum == n && rnum == n) {
            ans.add(buffer);
        }
        if(lnum >= rnum) {
            dfs(ans, buffer + "(", lnum + 1, rnum, n);
            dfs(ans, buffer + ")", lnum, rnum + 1, n);
        }
    }
}
