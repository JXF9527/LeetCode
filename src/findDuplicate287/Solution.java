package findDuplicate287;

public class Solution {
    /**
     * 鸽巢原理，二分
     * 示例 1:
     *         arr = [1,3,4,2,2] 此时数字在 1 — 5 之间
     *
     *         mid = (1 + 5) / 2 = 3 arr小于等于的3有4个(1,2,2,3)，1到3中肯定有重复的值
     *         mid = (1 + 3) / 2 = 2 arr小于等于的2有3个(1,2,2)，1到2中肯定有重复的值
     *         mid = (1 + 2) / 2 = 1 arr小于等于的1有1个(1)，2到2中肯定有重复的值
     *         所以重复的数是 2
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        if(nums.length <= 2)
            return 1;
        int low = 1, high = nums.length - 1;
        int mid = 0, i;
        int count;
        while (low < high) {
            mid = (low + high) >> 1;
            count = 0;

            for (i = 0; i < nums.length; ++i) {
                if (nums[i] <= mid)
                    ++count;
            }

            if (count > mid) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}
