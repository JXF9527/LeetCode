package canPartition416;

import java.util.*;

public class Solution {
    static private boolean ans;
    /**
     * 先计算数组所有整数的和sum，如果存在两个分割子集元素和相等，
     * 则子集和为sum/2，sum必须是偶数，问题转化为寻找和为sum/2的子集
     * @param nums
     * @return
     */
    static public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum+=nums[i];
        }
        if ((sum & 1) == 1)
            return false;
        sum >>= 1;
        Arrays.sort(nums);
        backTrack(nums, 0, sum);
        return ans;
    }

    static private void backTrack(int[] nums, int j, int sum) {

        if (sum == 0) {
            ans = true;
            return;
        }
        else if (sum < 0) {
            return;
        }

        for (int i = j; i < nums.length; ++i) {
            if (ans || nums[i] > sum)
                break;
            //不再取相同值
            if (i > j && nums[i] == nums[i - 1])
                continue;
            backTrack(nums, i + 1, sum - nums[i]);

        }

    }

    public static void main(String[] args) {
        canPartition(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100});
    }
}
