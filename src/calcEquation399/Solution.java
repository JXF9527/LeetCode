package calcEquation399;

import javafx.util.Pair;

import java.util.*;

public class Solution {
    /**
     * 代入法，失败
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        Map<String, Double> map = new HashMap<>();
        List<String> list;
        int i;
        int count = values.length;
        map.put(equations.get(0).get(0), 1.0);
        while (count > 0) {
            for (i = 0; i < values.length; ++i) {
                list = equations.get(i);
                if (map.containsKey(list.get(0)) && map.containsKey(list.get(1)))
                    break;
                if (map.containsKey(list.get(0))) {
                    map.put(list.get(1), map.get(list.get(0)) / values[i]);
                    --count;
                } else if (map.containsKey(list.get(1))) {
                    map.put(list.get(0), map.get(list.get(1)) * values[i]);
                    --count;
                }

            }

        }
        i = 0;
        Iterator<List<String>> it = queries.iterator();
        while (it.hasNext()) {
            list = it.next();
            if (map.containsKey(list.get(0)) && map.containsKey(list.get(1))) {
                ans[i++] = map.get(list.get(0)) / map.get(list.get(1));
            }
            else
                ans[i++] = -1.0;
        }

        return ans;
    }

    private int anstop;

    private Set<String> set = new HashSet<>();
    private Map<Pair<String, String>, Double> map = new HashMap<>();
    /**
     * 建立有向图，搜索
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        int i;
        List<String> list;
        //建立图
        for (i = 0; i < values.length; ++i) {
            list = equations.get(i);
            set.add(list.get(0));
            set.add(list.get(1));

            map.put(new Pair<>(list.get(0), list.get(1)), values[i]);
            map.put(new Pair<>(list.get(1), list.get(0)), 1 / values[i]);
        }

        Iterator<List<String>> it = queries.iterator();
        anstop = 0;
        while (it.hasNext()) {
            list = it.next();
            if (set.contains(list.get(0)) && set.contains(list.get(1))) {
                if (!dfs(list, ans, 1.0, list.get(0), new HashSet<>())) {
                    ans[anstop++] = -1.0;
                }
            }
            else {
                ans[anstop++] = -1.0;
            }
        }
        return ans;
    }

    private boolean dfs(List<String> ques, double[] ans, double tempans, String node, Set<String> visited) {
        if (node.equals(ques.get(1))) {
            ans[anstop++] = tempans;
            return true;
        }

        for (String nextnode : set) {
            Pair<String, String> pair = new Pair<>(node, nextnode);
            if (map.containsKey(pair) && !visited.contains(nextnode)) {
                visited.add(nextnode);
                if (dfs(ques, ans, tempans * map.get(pair), nextnode, visited)) {
                    return true;
                }
                visited.remove(nextnode);
            }
        }

        return false;
    }
}
