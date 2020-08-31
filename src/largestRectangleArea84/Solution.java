package largestRectangleArea84;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    /**
     * 朴素法
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int i, j;
        int len, area;
        int pos;
        int max = 0;
        for (i = 0; i < heights.length; i++) {
            pos = i;
            len = heights[pos];
            for (j = pos; j < heights.length; j++) {
                if (heights[j] == 0)
                    break;
                len = heights[j] < len ? heights[j] : len;
                area = (j - pos + 1)*(len);
                max = max > area ? max : area;
            }
        }
        return max;
    }

    /**
     * 单调栈
     * @param hei
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights.length == 1)
            return heights[0];
        Stack<Integer> stack = new Stack<>();
        int[] hei = Arrays.copyOf(heights, heights.length + 1);
        int top, left;
        int ans = 0;
        int i;
        for (i = 0; i < hei.length; i++) {
            while (!stack.empty() && hei[stack.peek()] > hei[i]) {
                top = stack.pop();
                left = stack.empty() ? i : (i - stack.peek() - 1);
                ans = Math.max(ans, hei[top]*left);
            }
            stack.push(i);
        }

        return ans;
    }
}
