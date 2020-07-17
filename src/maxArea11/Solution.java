package maxArea11;

public class Solution {
    /**
     * 暴力
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length - 1; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                ans = Math.max(ans, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return ans;
    }

    /**
     * 左右指针遍历，移动高度较小的一边以寻找更大面积
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                ans = Math.max(ans, (right - left) * height[left]);
                ++left;
            }
            else {
                ans = Math.max(ans, (right - left) * height[right]);
                --right;
            }
        }
        return ans;

    }
}
