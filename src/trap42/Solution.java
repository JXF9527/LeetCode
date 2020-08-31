package trap42;

public class Solution {
    /**
     * 两边扫描法,从左到右找左边缘比右边缘小的，从右到左找左边缘比右边缘大的
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length <= 1)
            return 0;
        int ans = 0;
        int content = 0;
        int left = 0, right = height.length - 1;
        int i;
        //从左到右找左边缘比右边缘小的
        for (i = 0; i < height.length; i++) {

            if (height[left] < height[i]) {
                ans += content;
                content = 0;
                left = i;
            }
            else if (height[left] > height[i]){
                content += height[left] - height[i];
            }

        }
        content = 0;
        //从右到左找左边缘比右边缘大的
        for (i = height.length - 1; i >= 0; i--) {

            if (height[right] <= height[i]) {
                ans += content;
                content = 0;
                right = i;
            }
            else {
                content += height[right] - height[i];
            }

        }

        return ans;
    }
}
