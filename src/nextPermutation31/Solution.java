package nextPermutation31;

import java.util.*;

public class Solution {
    /**
     * 从数组倒着查找，找到nums[i] 比nums[i+1]小的时候，
     * 就将nums[i]跟nums[i+1]到nums[nums.length - 1]当中找到一个最小的比nums[i]大的元素交换。
     * 交换后，再把nums[i+1]到nums[nums.length-1]排序
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1)
            return;
        int temp;
        int i, j;
        int min;
        for (i = nums.length - 2; i >= 0; --i) {

            if (nums[i] < nums[i + 1]) {
                min = i + 1;
                for (j = i + 2; j < nums.length; ++j) {
                    if (nums[i] < nums[j]) {
                        if (nums[min] > nums[j]) {
                            min = j;
                        }
                    }
                }
                temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
                Arrays.sort(nums, i + 1, nums.length);
                return;
            }

        }
        //没有下一个排列则排序
        for (i = 0; i < nums.length / 2; ++i) {
            temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }

    }
}
