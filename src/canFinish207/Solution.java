package canFinish207;

import javafx.util.Pair;

import java.util.*;

public class Solution {
    static private int count;

    /**
     * dfs
     * @param numCourses
     * @param prerequisites
     * @return
     */
    static public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int i, next;
        boolean[] dp = new boolean[numCourses];
        for (i = 0; i < prerequisites.length; ++i) {
            //有向边A -> B表示B是A的前置课程
            if (!map.containsKey(prerequisites[i][0]))
                map.put(prerequisites[i][0] ,new ArrayList<>());
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        count = numCourses;
        for (i = 0; i < numCourses && count > 0; ++i) {
            if (!map.containsKey(i)) {
                --count;
                dp[i] = true;
            }
            else if (!dp[i]) {
                if (!dfs(map, i, dp, new HashSet<>())) {
                    return false;
                }

            }
        }

        return true;
    }

    static private boolean dfs(Map<Integer, List<Integer>> map,int cur, boolean[] dp, Set<Integer> visited) {
        if (dp[cur]) {
            return true;
        }

        if (!map.containsKey(cur)) {
            dp[cur] = true;
            --count;
            return true;
        }
        visited.add(cur);
        List<Integer> nextlist = map.get(cur);
        int i;
        for (i = 0; i < nextlist.size(); ++i) {
            //出现死循环依赖，必定无解
            if (visited.contains(nextlist.get(i))) {
                return false;
            }
            if (!dfs(map, nextlist.get(i), dp, visited)) {
                return dp[cur];
            }
        }

        //只有三个前置都可达，当前课程才能上
        for (i = 0; i < nextlist.size(); ++i) {
            if (!dp[nextlist.get(i)]) {
                return false;
            }

        }
        --count;
        dp[cur] = true;
        visited.remove(cur);
        return true;
    }

    public static void main(String[] args) {
        canFinish(7,new int[][]{{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}});
    }
}
