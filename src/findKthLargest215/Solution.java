package findKthLargest215;

import java.util.*;

public class Solution {
    /**
     * 先排序
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    /**
     * 优先队列，小顶堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0;i < nums.length; ++i) {
            if(q.size() < k){
                q.offer(nums[i]);
            }else if(nums[i] > q.peek()){
                q.poll();
                q.offer(nums[i]);
            }
        }

        return q.peek();
    }
}
