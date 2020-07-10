package combinationSum39;

import java.util.*;

public class Solution {
    /**
     * 排序，回溯，去重
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<>(), ans, 0);
        return ans;

    }

    private void helper(int[] candidates, int target, List<Integer> list, List<List<Integer>> ans, int num) {
        if(target < 0) {
            return;
        }
        else if(target == 0) {
            /*Collections.sort(list);
            // 查重
            Iterator<List<Integer>> it = ans.iterator();
            Label : while (it.hasNext()) {
                List<Integer> alist = it.next();
                if(list.size() == alist.size()) {
                    Iterator<Integer> ita = alist.iterator();
                    Iterator<Integer> itb = list.iterator();
                    while (ita.hasNext()) {
                        if(! ita.next().equals(itb.next()))
                            continue Label;
                    }
                    return;
                }
            }*/
            ans.add(list);
            return;
        }
        else {
            for (int i = num; i < candidates.length; ++i) {
                if(candidates[i] > target)
                    break;
                List<Integer> tlist = new ArrayList<>(list);
                tlist.add(candidates[i]);
                //传递i，避免重复
                helper(candidates, target - candidates[i],tlist, ans, i);
            }
        }
    }
}
