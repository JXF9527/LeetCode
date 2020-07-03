package maxSubArray53;

public class Solution {
    /**
     * O(n)，贪心
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums.length <= 1)
            return nums.length == 1 ? nums[0] : 0;
        int maxsum = nums[0];
        int msum = maxsum;
        for (int i = 1; i < nums.length; ++i) {
            if(msum > 0){
                msum += nums[i];
            }
            else {
                msum = nums[i];
            }
            maxsum = maxsum > msum ? maxsum : msum;
        }
        return maxsum;
    }

    /**
     * O(n)，dp
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if(nums.length <= 1)
            return nums.length == 1 ? nums[0] : 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxsum = nums[0];
        for(int i = 1; i < nums.length; ++i){
            dp[i] = (dp[i - 1] + nums[i]) > nums[i] ? (dp[i - 1] + nums[i]) : nums[i];
            maxsum = maxsum > dp[i] ? maxsum : dp[i];
        }
        return maxsum;
    }
}
