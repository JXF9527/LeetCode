package lengthOfLIS300;

import java.util.*;

public class Solution {
    static private int max = 1;
    /**
     * 暴力
     * @param nums
     * @return
     */
    static public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int i, j;
        int ans = 0;
        for (i = 0; i < nums.length; ++i) {
            for (j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = dp[i] > (dp[j] + 1) ? dp[i] : dp[j] + 1;
                }
            }
        }

        for (i = 0; i < nums.length; ++i) {
            ans = ans > dp[i] ? ans : dp[i];
        }

        return ans;
    }

    /**
     * 维护一个结果数组，如果当前元素比结果数组的值都大的的话，
     * 就追加在结果数组后面（相当于递增序列长度加了1）；否则的话用当前元素覆盖掉第一个比它大的元素
     * @param nums
     * @return
     */
    static public int lengthOfLIS2(int[] nums) {
        int[] ans = new int[nums.length];
        int index;
        int max = 0;
        for (int num : nums) {
            //[1] 搜索值不是数组元素，且在数组范围内，得“ - 插入点索引值 - 1”；
            //[2] 搜索值是数组元素，从0开始计数，得搜索值的索引值；
            //[3] 搜索值不是数组元素，且大于数组内元素，索引值为 – (length + 1);
            //[4] 搜索值不是数组元素，且小于数组内元素，索引值为 – 1。
            index = Arrays.binarySearch(ans, 0, max,num);
            index = index < 0 ? -index - 1 : index;
            ans[index] = num;
            if (index == max)
                ++max;
        }

        return max;
    }


    public static void main(String[] args) {
        lengthOfLIS2(new int[]{10,9,2,5,3,7,101,18});
    }
}
