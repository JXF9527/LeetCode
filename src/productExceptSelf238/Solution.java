package productExceptSelf238;

import java.util.Arrays;

public class Solution {
    /**
     * 就用除法
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int star = 1;
        int i = 0;
        int countZero = 0;
        int posZero = -1;
        for (i = 0; i < nums.length; ++i) {
            if(nums[i] != 0)
                star *= nums[i];
            else {
                posZero = i;
                ++countZero;
            }
        }
        if(countZero > 0) {
            if(countZero == 1)
                ans[posZero] = star;
            return ans;
        }
        for (i = 0; i < nums.length; ++i) {
            ans[i] = star / nums[i];
        }
        return ans;
    }

    /**
     * 左右乘积法
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 1, right = 1;
        int length = nums.length;
        Arrays.fill(ans, 1);
        for (int i = 0; i < length; ++i) {
            ans[i] *= left;
            left *= nums[i];
            ans[length - i - 1] *= right;
            right *= nums[length - 1 - i];
        }
        return ans;
    }
}
