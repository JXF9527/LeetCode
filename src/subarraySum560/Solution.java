package subarraySum560;

import java.util.*;

public class Solution {
    /**
     * Hash法,扫描一遍数组, 使用map记录出现同样的和的次数, 对每个i计算累计和sum并判断map内是否有sum-k
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0)
            return 0;
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }

    /**
     * 暴力O(n^2)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        if (nums.length == 0)
            return 0;
        int i, j;
        int ans = 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (i = 1; i < nums.length; ++i) {
            sum[i] = sum[i - 1] + nums[i];
        }

        for (i = 0; i < nums.length; ++i) {
            if (sum[i] == k)
                ++ans;
            for (j = 0; j < i; ++j) {
                if (sum[i] - sum[j] == k)
                    ++ans;
            }
        }

        return ans;
    }
}
