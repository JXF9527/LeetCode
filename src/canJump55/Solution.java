package canJump55;

import java.util.*;


public class Solution {
    static private boolean ans = false;

    /**
     * 回溯法
     * 如果所有元素都不为0， 那么一定可以跳到最后；
     * 从后往前遍历，如果遇到nums[i] = 0，就找i前面的元素j，使得nums[j] > i - j。如果找不到，则不可能跳跃到num[i+1]，返回false。
     * @param nums
     * @return
     */
    static public boolean canJump(int[] nums) {
        if (nums.length == 0)
            return false;
        backTrack(nums, 0, nums.length - 1, new boolean[nums.length]);
        return ans;
    }

    static private void backTrack(int[] nums, int pos, int target, boolean[] visited) {
        if (ans)
            return;
        if (visited[pos])
            return;
        if (target == 0) {
            ans = true;
            return;
        }
        else if (target < 0)
            return;


        for (int j = 1; j <= nums[pos]; j++) {
            backTrack(nums, pos + j, target - j, visited);
        }
        visited[pos] = true;
    }

    /**
     * 如果所有元素都不为0， 那么一定可以跳到最后；
     * 从后往前遍历，如果遇到nums[i] = 0，就找i前面的元素j，
     * 使得nums[j] > i - j。如果找不到，则不可能跳跃到num[i+1]，返回false。
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        if (nums.length == 0)
            return false;
        List<Integer> list = new ArrayList<>();
        Iterator<Integer> it;
        for (int i = nums.length - 2; i >= 0; --i) {
            it = list.iterator();
            while (it.hasNext()) {
                if (nums[i] + i > it.next()) {
                    it.remove();
                }
            }
            if (nums[i] == 0)
                list.add(i);

        }

        return list.isEmpty();
    }


    /**
     * 如果一个位置可达，则其前面的位置一定可达
     * 如果当前位置不在最大可达范围内，则无法到达终点
     * @param nums
     * @return
     */
    public boolean canJump3(int[] nums) {
        if (nums.length == 0)
            return false;
        int maxreach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxreach)
                return false;
            maxreach = maxreach > i + nums[i] ? maxreach : i + nums[i];
        }
        return true;
    }

    public static void main(String[] args) {
        canJump(new int[]{3,2,1,0,4});
    }
}
