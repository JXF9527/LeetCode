package twoSum1;


import java.util.*;


public class Solution {
    int[] ans = new int[2];
    /**
     * 暴力搜索
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; ++i){
            for (int j = i + 1; j < nums.length; ++j){
                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    /**
     * Map方法，key是补数，value是下标
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i){
            if(map.containsKey(nums[i])){
                ans[0] = i;
                ans[1] = map.get(nums[i]);
                return ans;
            }
            map.put(target - nums[i], i);
        }
        return ans;
    }

}
