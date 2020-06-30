package majorityElement169;

import java.util.Arrays;

public class Solution {
    /**
     * 直接排序
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int major = nums[0];
        int count = 1;
        int i = 1;
        for(i = 1; i < nums.length; ++i){
            if(count == 0)
                major = nums[i];
            if(major != nums[i])
                --count;
            else
                ++count;
        }
        return major;
    }
}
