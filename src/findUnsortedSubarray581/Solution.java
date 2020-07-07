package findUnsortedSubarray581;

import java.util.Arrays;

public class Solution {
    /**
     * 从左到右找出最后一个破坏递增的数
     * 从右到左找出最后一个破坏递减的数
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if(len <= 1)
            return 0;
        int high = 0, low = len-1, max = nums[0], min = nums[len-1];
        for(int i = 1; i < len; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len-1-i]);
            if(nums[i] < max) high = i;
            if(nums[len-1-i] > min) low = len-1-i;
        }
        return high > low ? high - low + 1 : 0;
    }

    /**
     * 排序比较法
     * @param nums
     * @return
     */
    public int findUnsortedSubarray2(int[] nums) {
        int[] array = nums.clone();
        Arrays.sort(array);
        int i, j;
        for (i = 0, j = nums.length - 1; i < j; ) {
            if(array[i] == nums[i])
                ++i;
            if(array[j] == nums[j])
                --j;
            if(array[i] != nums[i] && array[j] != nums[j])
                return j - i + 1;
        }
        return 0;
    }
}
