package permute46;

import java.util.*;

public class Solution {
    /**
     * 回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] visited = new int[nums.length];
        backTrack(ans, nums, new ArrayList<>(), visited);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, int[] nums, List<Integer> list, int[] visited) {
        if(nums.length == list.size()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if(visited[i] == 1)
                continue;
            list.add(nums[i]);
            visited[i] = 1;
            backTrack(ans, nums, list, visited);
            visited[i] = 0;
            list.remove(list.size() - 1);
        }
    }
}
