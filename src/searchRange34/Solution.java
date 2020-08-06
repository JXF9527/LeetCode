package searchRange34;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int pos = Arrays.binarySearch(nums, target);
        int first = pos;
        int last = pos;
        if(pos >= 0) {
            while (first > 0 && nums[first - 1] == nums[pos])
                --first;
            while (last < nums.length - 1 && nums[last + 1] == nums[pos])
                ++last;
            ans[0] = first;
            ans[1] = last;
        }
        return ans;
    }
}
