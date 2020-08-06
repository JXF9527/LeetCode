package maxProduct152;

public class Solution {
    /**
     * 最大、最小调转法
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int i;
        int max = Integer.MIN_VALUE;
        int cmax = 1, cmin = 1;
        int temp;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                temp = cmax;
                cmax = cmin;
                cmin = temp;
            }

            cmax = Math.max(nums[i], cmax * nums[i]);
            cmin = Math.min(nums[i], cmin * nums[i]);

            max = max > cmax ? max : cmax;
        }

        return max;
    }
}
