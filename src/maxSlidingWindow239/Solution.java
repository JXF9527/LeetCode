package maxSlidingWindow239;

import java.util.*;

public class Solution {
    /**
     * 用TreeMap维护
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int i, j = 0;

        for (i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        ans[j++] = map.lastKey();
        for (i = k; i < nums.length; i++) {
            if (map.get(nums[i - k]) == 1)
                map.remove(nums[i - k]);
            else
                map.put(nums[i - k], map.get(nums[i - k]) - 1);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            ans[j++] = map.lastKey();
        }

        return ans;
    }
    /*
      用head和tail控制一个窗口 第一次的时候遍历整个窗口的数据得到最大值 其他时间需要分情况，滑动窗口每次移动相当于除去头部数据，
      在尾部加入一个新数据（可以理解为长度固定的双端队列） 如果新加入的数据比移动前的滑动窗口中的最大值大或者两者相等
      ，那么此滑块最大值就是新加入的尾部数据 如果新加入的数据比移动前的滑动窗口中的最大值还要小，
      那么需要判断之前去掉的头部数据是不是最大值，如果不是则此滑动窗口的最大值和移动前的滑动窗口的最大值相同，否则需要遍历求最大值
     */
}
