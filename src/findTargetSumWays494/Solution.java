package findTargetSumWays494;

import java.util.*;

public class Solution {
    /**
     * 维护一个map，存放目前为止和为key的方法数value
     * 遍历数组，key + num[i]或key - num[i]作为新key建立新map
     * @param nums
     * @param S
     * @return
     */
    static public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        map.put(-nums[0], map.getOrDefault(-nums[0], 0) + 1);
        for (int i = 1; i < nums.length; ++i) {
            Map<Integer, Integer> tempmap = new HashMap<>();

            for (int key : map.keySet()) {
                tempmap.put(key + nums[i], map.get(key) + tempmap.getOrDefault(key + nums[i], 0));
                tempmap.put(key - nums[i], map.get(key) + tempmap.getOrDefault(key - nums[i], 0));
            }
            map = tempmap;
        }

        return map.getOrDefault(S, 0);
    }

    /**
     * 数学规律：假设P是正子集，N是负子集，有
     *                          sum(P) - sum(N) = target
     *              sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     *                       2 * sum(P) = target + sum(nums)
     *                       sum(P) = (target + sum(nums)) / 2
     * 只需要寻找正子集，转化为求目标子集和问题
     * @param nums
     * @param S
     * @return
     */
    private int ans;
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }

        if ((sum + S) % 2 != 0)
            return 0;

        sum = (sum + S) >> 1;

        ans = 0;
        Arrays.sort(nums);
        backTrack(nums, sum, 0);
        return ans;
    }

    private void backTrack(int[] nums, int sum, int j) {
        if (sum == 0) {
            ans++;
        }
        else if (sum < 0)
            return;

        for (int i = j; i < nums.length; ++i) {
            if (sum < nums[i])
                break;
            backTrack(nums, sum - nums[i], i + 1);
        }
    }

    public static void main(String[] args) {
        findTargetSumWays(new int[]{1,1,1,1,1}, 3);
    }
}
