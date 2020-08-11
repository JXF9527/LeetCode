package threeSum15;

import java.util.*;

public class Solution {
    /**
     * 对每一个数找两数和与之相等的数对
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();
        Set<Integer> set = new HashSet<>();

        int i, j;
        List<Integer> tmp;
        //排序方便去重
        Arrays.sort(nums);
        if (nums[0] > 0)
            return new ArrayList<>();

        for (i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (j = i + 1; j < nums.length; j++) {

                if (set.contains(nums[j])) {
                    tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(-nums[i] - nums[j]);
                    tmp.add(nums[j]);
                    //Collections.sort(tmp);
                    ans.add(tmp);
                    //去重

                }
                else {
                    set.add(-nums[i] - nums[j]);
                }


            }
            set.clear();

        }

        return new ArrayList<>(ans);
    }

    /**
     * 回溯
     * @param nums
     * @return
     */
    static public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        backTrack(nums, ans, 0, new ArrayList<>(), 0);
        return new ArrayList<>(ans);
    }

    static private void backTrack(int[] nums, Set<List<Integer>> ans, int pos, List<Integer> pass, int sum) {
        if (sum == 0 && pass.size() == 3) {
            List<Integer> list = new ArrayList<>(pass);
            Collections.sort(list);
            ans.add(list);
            return;
        }

        if (pass.size() >= 3)
            return;

        for (int i = pos; i < nums.length; i++) {
            pass.add(nums[i]);
            backTrack(nums, ans, i + 1, pass,sum + nums[i]);
            pass.remove(pass.size() - 1);
        }

    }

    public static void main(String[] args) {
        threeSum2(new int[]{1,-1,-1,0});
    }
}
